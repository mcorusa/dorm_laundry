package controller;

import main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login {
    @FXML
    Button loginBtn;

    @FXML
    TextField usernameTxt;

    @FXML
    TextField passwdTxt;

    @FXML
    Label errorLbl;

    @FXML
    public void loginm(ActionEvent ev){
        String username = this.usernameTxt.getText().toString();
        String password = this.passwdTxt.getText().toString();

        if (username.equals("") || password.equals("")){
            errorLbl.setVisible(true);
           // uspjehLbl.setVisible(false);
        } else {
            errorLbl.setVisible(false);
           // uspjehLbl.setVisible(true);

            try {
                Main.showWindow(
                        getClass(),
                        "../view/Admin.fxml",
                        "Welcome Admin", 700, 500
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
