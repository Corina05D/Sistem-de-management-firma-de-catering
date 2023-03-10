package businessLayer;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

import dataLayer.FileWriter;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    public static TreeSet<MenuItem> menuItems = new TreeSet<>();
    public static HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();
    public static ArrayList<User> users = new ArrayList<>();
    private static final String adminUsername = "admin";
    private static final String adminPassword = "admin";
    private static final String employeeUsername = "employee";
    private static final String employeePassword = "employee";

    static {
        User admin = new User(adminUsername, adminPassword, "ADMIN");
        User employee = new User(employeeUsername, employeePassword, "EMPLOYEE");
        users.add(admin);
        users.add(employee);
    }


    public static Function<String, BaseProduct> mapToProduct = (line) -> {
        String[] p = line.split(",");
        return new BaseProduct(p[0].replace("\"", ""), Float.parseFloat(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
                Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]));
    };

    @Override
    public void importProducts() throws FileNotFoundException {
        InputStream is = new FileInputStream(new File("C:\\Users\\40770\\Documents\\PT2022_30224_Dragotoniu_Corina_Assignment_4\\src\\main\\resources\\produse.csv"));
        assert is != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        TreeSet<BaseProduct> baseProducts = br.lines()
                .skip(1)
                .map(mapToProduct)
                .collect(Collectors.toCollection(TreeSet::new));
        menuItems.addAll(baseProducts);
        assert !menuItems.isEmpty();
        assert isWellFormed();
    }

    @Override
    public void addProductsToMenu(MenuItem menuItem) {
        assert menuItem != null;
        menuItems.add(menuItem);
        assert menuItems.contains(menuItem);
        assert isWellFormed();
    }

    @Override
    public void deleteProductFromMenu(String menuTitle) {
        assert !menuTitle.isEmpty();
        int oldSize = menuItems.size();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getTitle().equals(menuTitle)) {
                menuItems.remove(menuItem);
                break;
            }
        }
        assert menuItems.size() == (oldSize - 1);
        assert isWellFormed();
    }

    @Override
    public void editProductFromMenu(String oldMenuItem, MenuItem newMenuItem) {
        assert !oldMenuItem.isEmpty();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getTitle().equals(oldMenuItem)) {
                menuItems.remove(menuItem);
                menuItems.add(newMenuItem);
                break;
            }
        }
        assert menuItems.contains(newMenuItem);
        assert isWellFormed();
    }

    @Override
    public void generateTimeReport(int startHour, int endHour) throws IOException {
        assert startHour <= endHour;
        FileWriter fileWriter = new FileWriter("Raport1.txt");
        String text = orders
                .keySet()
                .stream()
                .filter(p -> p.getDate().getHour() < endHour)
                .filter(p -> p.getDate().getHour() >= startHour)
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
        fileWriter.write(text);
        fileWriter.close();

        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    @Override
    public void generateFrequencyReport(int numberOfTimesOrdered) throws IOException {
        assert numberOfTimesOrdered >= 0;
        FileWriter fileWriter = new FileWriter("Raport2.txt");
        ArrayList<MenuItem> products = new ArrayList<>();
        orders
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .forEach(products::addAll);

        filterProductsByFrequency(numberOfTimesOrdered, fileWriter, products);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    @Override
    public void generateFrequencyAndValueReport(int numberOfTimesOrdered, int amount) throws IOException {
        assert numberOfTimesOrdered >= 0 && amount >= 0;
        FileWriter fileWriter = new FileWriter("Raport3.txt");
        ArrayList<Integer> clients = new ArrayList<>();
        orders
                .keySet()
                .stream()
                .filter(items -> items.getPrice() > amount)
                .forEach(c -> clients.add(c.getClientID()));

        filterClientsByFrequency(numberOfTimesOrdered, fileWriter, clients);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    @Override
    public void generateDateReport(LocalDate localDate) throws IOException {
        assert localDate != null;
        FileWriter fileWriter = new FileWriter("Raport4.txt");
        ArrayList<MenuItem> products = new ArrayList<>();
        orders
                .entrySet()
                .stream()
                .filter(p -> p.getKey().getDate().toLocalDate().equals(localDate))
                .map(Map.Entry::getValue)
                .forEach(products::addAll);

        filterProductsByFrequency(0, fileWriter, products);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    private void filterClientsByFrequency(int numberOfTimesOrdered, FileWriter fileWriter, ArrayList<Integer> clients) throws IOException {
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        AtomicReference<String> text = new AtomicReference<>("");
        clients
                .stream()
                .forEach(c -> frequency.put(c, Collections.frequency(clients, c)));

        frequency
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > numberOfTimesOrdered)
                .forEach(p -> {
                    text.getAndSet(text.get() + "Clientul cu ID " + p.getKey() + " a comandat de " + p.getValue() + " ori.\n");
                });

        fileWriter.write(text.get());
        fileWriter.close();
    }

    private void filterProductsByFrequency(int numberOfTimesOrdered, FileWriter fileWriter, ArrayList<MenuItem> products) throws IOException {
        TreeMap<MenuItem, Integer> frequency = new TreeMap<>();
        AtomicReference<String> text = new AtomicReference<>("");
        products
                .stream()
                .forEach(p -> frequency.put(p, Collections.frequency(products, p)));

        frequency
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > numberOfTimesOrdered)
                .forEach(p -> {
                    text.getAndSet(text.get() + p.getKey().getTitle() + " apare de " + p.getValue() + " ori.\n");
                });

        fileWriter.write(text.get());
        fileWriter.close();
    }

    @Override
    public void createOrder(int clientID, LocalDateTime date, ArrayList<MenuItem> menuItems) throws IOException {
        assert !menuItems.isEmpty();
        int orderValue = 0;
        for (MenuItem menuItem : menuItems)
            orderValue += menuItem.getPrice();
        Order newOrder = new Order(clientID, date, orderValue);
        orders.put(newOrder, menuItems);
        FileWriter fileWriter = new FileWriter("comanda" + newOrder.getOrderID() + ".txt");
        String text = newOrder + "\n" + "Produse comandate:\n";
        for (MenuItem menuItem : menuItems)
            text += menuItem.getTitle() + "\n";
        fileWriter.write(text);
        fileWriter.close();

        String ordersText = "";
        for (Order order : orders.keySet()) {
            ordersText += order + "\nItem comandat:\n";
            for (MenuItem menuItem : orders.get(order)) {
                ordersText += menuItem + "\n";
            }
            ordersText += "\n";
        }
        setChanged();
        notifyObservers(ordersText);

        assert !orders.isEmpty();
        assert isWellFormed();
    }

    @Override
    public TreeSet<MenuItem> searchForProduct(String keyword, float rating, int price, int calories, int protein, int fat, int sodium) {
        assert price >= 0;
        TreeSet<MenuItem> productsFound = menuItems
                .stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .filter(p -> p.getRating() >= rating)
                .filter(p -> p.getProtein() >= protein)
                .filter(p -> p.getPrice() <= price)
                .filter(p -> p.getSodium() <= sodium)
                .filter(p -> p.getFat() <= fat)
                .collect(Collectors.toCollection(TreeSet::new));
        assert !productsFound.isEmpty();
        assert isWellFormed();
        return productsFound;
    }

    private boolean isWellFormed() {
        return !users.isEmpty();
    }
}
