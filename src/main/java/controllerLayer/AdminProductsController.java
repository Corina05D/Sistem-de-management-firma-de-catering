package controllerLayer;

import businessLayer.CompositeProduct;
import businessLayer.DeliveryService;
import viewLayer.AddProductView;
import viewLayer.AdminProductsView;
import viewLayer.CreateCompositeItemView;

public class AdminProductsController {
    private DeliveryService deliveryService;
    private AdminProductsView adminProductsView;
    private CompositeProduct compositeProduct = null;

    public AdminProductsController(AdminProductsView adminProductsView, DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        this.adminProductsView = adminProductsView;
        this.adminProductsView.addAddActionListener(e -> {
            AddProductView addProductView = new AddProductView();
            addProductView.setVisible(true);
            AddProductController addProductController = new AddProductController(addProductView, deliveryService, adminProductsView.getTableModel());
        });

        this.adminProductsView.addRemoveActionListener(e -> deliveryService.deleteProductFromMenu(adminProductsView.removeCurrentRow()));

        this.adminProductsView.addSaveEditActionListener(e -> deliveryService.editProductFromMenu(adminProductsView.getSelectedTitle(), adminProductsView.getEditedMenuItem()));

        this.adminProductsView.addAddToComposedItemActionListener(e -> {
            if (compositeProduct == null) {
                compositeProduct = new CompositeProduct();
            }
            compositeProduct.addMenuItem(adminProductsView.getEditedMenuItem());
        });

        this.adminProductsView.addProcessComposedProductActionListener(e -> {
            CreateCompositeItemView createCompositeItemView = new CreateCompositeItemView();
            createCompositeItemView.setVisible(true);
            CreateCompositeItemController createCompositeItemController = new CreateCompositeItemController(createCompositeItemView, compositeProduct, deliveryService, adminProductsView.getTableModel());
            compositeProduct = null;
        });

    }
}
