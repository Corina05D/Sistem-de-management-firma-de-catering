package controllerLayer;

import businessLayer.Client;
import businessLayer.DeliveryService;
import businessLayer.User;
import viewLayer.SignUpView;


public class SignUpController {
    private SignUpView signUpView;

    public SignUpController(SignUpView signUpView) {
        this.signUpView = signUpView;
        this.signUpView.addSignUpBtnListener(e -> {
            String username = signUpView.getUsername();
            String name = signUpView.getName();
            String password = signUpView.getPassword();
            String role = "CLIENT";
            User newUser = new Client(username, name, password, role);
            DeliveryService.users.add(newUser);
            signUpView.showError("Utilizator inregistrat cu succes!");
        });
    }
}
