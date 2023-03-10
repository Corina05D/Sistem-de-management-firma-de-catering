package controllerLayer;


import businessLayer.DeliveryService;
import viewLayer.AddProductView;

import javax.swing.table.DefaultTableModel;

public class AddProductController {
    private AddProductView addProductView;
    private DeliveryService deliveryService;
    private DefaultTableModel table;

    public AddProductController(AddProductView addProductView, DeliveryService deliveryService, DefaultTableModel table) {
        this.addProductView = addProductView;
        this.deliveryService = deliveryService;
        this.table = table;
        this.addProductView.addAddButtonActionListener(e -> {
            deliveryService.addProductsToMenu(addProductView.getNewMenuItem());
            table.addRow(addProductView.newRow());
        });
    }
}
