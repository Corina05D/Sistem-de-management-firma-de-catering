package controllerLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import viewLayer.ClientProductsView;
import viewLayer.SearchView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClientController {
    private DeliveryService deliveryService;
    private ClientProductsView clientProductsView;
    private ArrayList<MenuItem> menuItems = null;
    private int clientID;

    public ClientController(ClientProductsView clientProductsView, DeliveryService deliveryService, int clientID) {
        this.clientProductsView = clientProductsView;
        this.deliveryService = deliveryService;
        this.clientID = clientID;

        this.clientProductsView.addSearchForProductActionListener(e -> {
            SearchView searchView = new SearchView();
            searchView.setVisible(true);
            SearchController searchController = new SearchController(searchView, deliveryService);

        });

        this.clientProductsView.addPlaceOrderActionListener(e -> {
            try {
                deliveryService.createOrder(clientID, LocalDateTime.now(), menuItems);
                menuItems = null;
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        this.clientProductsView.addAddActionListener(e -> {
            if (menuItems == null)
                menuItems = new ArrayList<>();
            menuItems.add(clientProductsView.getCurrentMenuItem());

        });

    }

}
