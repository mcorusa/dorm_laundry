package controller;

import main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Employee;

import java.io.IOException;

public class Login {
    @FXML
    public static Employee loggedInEmployee;

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
        String username = this.usernameTxt.getText();
        String password = this.passwdTxt.getText();
        //toString() removed due to the redudancy

        if (username.equals("") || password.equals("")){
            errorLbl.setVisible(true);
            // uspjehLbl.setVisible(false);
        } else {
            errorLbl.setVisible(false);
            // uspjehLbl.setVisible(true);

            try {
                Login.loggedInEmployee= Employee.login(username, password);

                if(Login.loggedInEmployee!=null )
                {
                    if(Login.loggedInEmployee.getRole().equals("admin")){Main.showWindow(getClass(), "../view/Admin.fxml", "Welcome Admin", 700, 500); }
                    else {Main.showWindow(getClass(), "../view/Employee.fxml", "Welcome", 700, 500);}
                }
                else{ errorLbl.setVisible(true); }


            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}