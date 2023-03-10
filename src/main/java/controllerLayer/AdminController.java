package controllerLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import viewLayer.AdminProductsView;
import viewLayer.AdminView;
import viewLayer.GenerateReportsView;

import java.io.FileNotFoundException;

public class AdminController {
    private AdminView adminView;
    private DeliveryService deliveryService;

    public AdminController(AdminView adminView, DeliveryService deliveryService) {
        this.adminView = adminView;
        this.deliveryService = deliveryService;
        this.adminView.addGenerateReportsBtnActionListener(e -> {
            GenerateReportsView generateReportsView = new GenerateReportsView();
            generateReportsView.setVisible(true);
            GenerateReportsController generateReportsController = new GenerateReportsController(generateReportsView, deliveryService);
        });
        this.adminView.addImportProductsBtnActionListener(e -> {
            try {
                deliveryService.importProducts();
                adminView.showError("Produse importate cu succes!");

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        this.adminView.addManageProductsBtnActionListener(e -> {
            AdminProductsView adminProductsView = new AdminProductsView(getRowData());
            AdminProductsController adminProductsController = new AdminProductsController(adminProductsView, deliveryService);
            adminProductsView.setVisible(true);

        });
    }

    public String[][] getRowData() {
        String[][] data = new String[DeliveryService.menuItems.size()][7];
        int i = 0;
        for (MenuItem menuItem : DeliveryService.menuItems) {
            data[i][0] = menuItem.getTitle();
            data[i][1] = menuItem.getRating() + "";
            data[i][2] = menuItem.getCalories() + "";
            data[i][3] = menuItem.getProtein() + "";
            data[i][4] = menuItem.getFat() + "";
            data[i][5] = menuItem.getSodium() + "";
            data[i][6] = menuItem.getPrice() + "";
            i++;
        }
        return data;
    }

}
