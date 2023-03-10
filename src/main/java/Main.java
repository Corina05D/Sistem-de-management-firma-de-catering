import businessLayer.DeliveryService;
import controllerLayer.LogInController;
import dataLayer.Serializator;
import viewLayer.LogInView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Serializator.deserialize();
        DeliveryService ds = new DeliveryService();
        LogInView logInView = new LogInView();
        logInView.setVisible(true);
        LogInController logInController = new LogInController(logInView, ds);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> Serializator.serialize()));
    }
}
