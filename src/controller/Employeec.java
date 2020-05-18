package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import main.Main;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Employeec implements Initializable {

    //-----------------------------employee menu-----------------------------
    @FXML
    private Pane Pn1employee;
    @FXML
    Label lblLoggedEmployee;
    @FXML
    Button btnLogOut;
    @FXML
    Button BtnStudents;
    @FXML
    Button BtnReservations;


    //-----------------------------employee student-----------------------------
    @FXML
    private Pane Pn2student;
    //buttons
    @FXML
    Button btnBacks;
    @FXML
    Button btnAddstudent;
    @FXML
    Button btnDeletestudent;
    //text fields
    @FXML
    TextField txtSname;
    @FXML
    TextField txtSlastname;
    @FXML
    TextField txtStelephone;
    @FXML
    TextField txtSid;


    //-----------------------------employee reservation-----------------------------
    @FXML
    private Pane Pn3reservation;
    //buttons
    @FXML
    Button btnBackr;
    @FXML
    Button btnMakeReservation;
    @FXML
    Button btnRemoveReservation;
    //text fields
    @FXML
    TextField txtSnameReservation;
    @FXML
    TextField txtSlastnameReservation;
    @FXML
    TextField txtCycle;
    @FXML
    TextField txtTime;
    //table
    @FXML
    TableView tableReservations;

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource().equals(BtnStudents)){
            Pn2student.toFront();
        }
        if(event.getSource().equals(BtnReservations)){
            Pn3reservation.toFront();
        }
        if(event.getSource().equals(btnBackr) || event.getSource().equals(btnBacks)) {
            Pn1employee.toFront();
        }

        // add student to db
        if(event.getSource().equals(btnAddstudent)){
            Student st = new Student();
            st.setFirstname(this.txtSname.getText());
            st.setLastname(this.txtSlastname.getText());
            st.setTelephone(this.txtStelephone.getText());

            try {
                st.save();
                this.txtSname.setText("");
                this.txtSlastname.setText("");
                this.txtStelephone.setText("");

            } catch (Exception e) {
                System.out.println("Nope");
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lblLoggedEmployee.setText(Login.loggedInEmployee.getFirstname() + " " + Login.loggedInEmployee.getLastname());
    }
    @FXML
    public  void Logout (ActionEvent ev) throws IOException {
        Main.showWindow(getClass(), "../view/Login.fxml", "Login", 700, 500);
        Login.loggedInEmployee=null;
    }
}
