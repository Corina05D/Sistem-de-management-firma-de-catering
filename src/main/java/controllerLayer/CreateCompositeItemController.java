package controllerLayer;

import businessLayer.CompositeProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import viewLayer.CreateCompositeItemView;

import javax.swing.table.DefaultTableModel;

public class CreateCompositeItemController {
    private CreateCompositeItemView createCompositeItemView;
    private CompositeProduct compositeProduct;
    private DefaultTableModel tableModel;

    public CreateCompositeItemController(CreateCompositeItemView createCompositeItemView, CompositeProduct product, DeliveryService deliveryService, DefaultTableModel table) {
        this.createCompositeItemView = createCompositeItemView;
        this.compositeProduct = product;
        this.tableModel = table;
        this.createCompositeItemView.addCreateButtonActionListener(e -> {
            String title = createCompositeItemView.getTitle();
            if (!title.equals("")) {
                System.out.println(title);
                compositeProduct.setTitle(title);
                deliveryService.addProductsToMenu(compositeProduct);
                tableModel.addRow(getRowData(compositeProduct));
            }
        });
    }

    private String[] getRowData(MenuItem menuItem) {
        return new String[]{menuItem.getTitle(), "" + menuItem.getRating(), "" + menuItem.getCalories(), "" + menuItem.getProtein(),
                "" + menuItem.getFat(), "" + menuItem.getSodium(), "" + menuItem.getPrice()};
    }

}
