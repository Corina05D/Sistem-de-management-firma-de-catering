package businessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public interface IDeliveryServiceProcessing {

    void importProducts() throws FileNotFoundException;

    void addProductsToMenu(MenuItem menuItem);

    void deleteProductFromMenu(String menuTitle);

    void editProductFromMenu(String oldMenuItem, MenuItem newMenuItem);

    void generateTimeReport(int startHour, int endHour) throws IOException;

    void generateFrequencyReport(int numberOfTimesOrdered) throws IOException;

    void generateFrequencyAndValueReport(int numberOfTimesOrdered, int amount) throws IOException;

    void generateDateReport(LocalDate localDate) throws IOException;

    void createOrder(int clientID, LocalDateTime date, ArrayList<MenuItem> menuItems) throws IOException;

    TreeSet<MenuItem> searchForProduct(String keyword, float rating, int calories, int protein, int fat, int sodium, int price);

}
