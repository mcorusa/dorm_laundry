package controller;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin implements Initializable {

    // admin menu
    @FXML
    private Pane Pn1admin;
    @FXML
    Button BtnAddemployee;
    @FXML
    Button BtnAddmachine;
    @FXML
    Button BtnAddstudent;
    @FXML
    Button BtnReports;


    //manage employees
    @FXML
    private Pane Pn2employee;
    @FXML
    TextField TxtName;
    @FXML
    TextField TxtLastname;
    @FXML
    TextField TxtEmail;
    @FXML
    TextField TxtUsername;
    @FXML
    PasswordField TxtPassword;
    @FXML
    Button btnAddemployee;
    @FXML
    Button BtnBack2;
    @FXML
    TableView TableEmployee;
    @FXML
    TableColumn ColumnEmployeeID;
    @FXML
    TableColumn ColumnEmployeeName;
    @FXML
    TableColumn ColumnEmployeeLastname;
    @FXML
    TableColumn ColumnEmployeeEmail;
    @FXML
    TableColumn ColumnEmployeeUsername;
    @FXML
    TableColumn ColumnEmployeePassword;

    //manage students
    @FXML
    private Pane Pn3student;
    @FXML
    Button btnAddstudent;
    @FXML
    TextField txtSname;
    @FXML
    TextField txtSlastname;
    @FXML
    TextField txtStelephone;
    @FXML
    Button BtnBack3;

    //manage machines and cycles
    @FXML
    private Pane Pn4machine;
    @FXML
    TextField txtModel;
    @FXML
    TextField txtMachineIDadd;
    @FXML
    TextField txtType;
    @FXML
    TextField txtDuration;
    @FXML
    TextField txtPrice;

    @FXML
    Button btnAddMachine;
    @FXML
    Button btnRemoveMachine;
    @FXML
    Button btnAddCycle;
    @FXML
    Button BtnBack4;

    //reports
    @FXML
    private Pane Pn5reports;
    @FXML
    Button BtnBack5;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.ColumnEmployeeID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.ColumnEmployeeName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.ColumnEmployeeLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.ColumnEmployeeEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.ColumnEmployeeUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.ColumnEmployeePassword.setCellValueFactory(new PropertyValueFactory<>("password"));

    }

    @FXML
    private void handleButtonAction(ActionEvent event){

        if(event.getSource().equals(BtnAddemployee)){
            Pn2employee.toFront();
        }

        if(event.getSource().equals(BtnAddstudent)){
            Pn3student.toFront();
        }

        if(event.getSource().equals(BtnAddmachine)) {
            Pn4machine.toFront();
        }

        if(event.getSource().equals(BtnReports)) {
            Pn5reports.toFront();
        }


        if(event.getSource().equals(btnAddemployee)){
            Employee em = new Employee();
            em.setFirstname(this.TxtName.getText());
            em.setLastname(this.TxtLastname.getText());
            em.setEmail(this.TxtEmail.getText());
            em.setUsername(this.TxtUsername.getText());
            em.setPassword(this.TxtPassword.getText());
            em.setRole("zaposlenik");
            try {
                em.save();
                this.TxtName.setText("");
                this.TxtLastname.setText("");
                this.TxtEmail.setText("");
                this.TxtUsername.setText("");
                this.TxtPassword.setText("");

            } catch (Exception e) {
                System.out.println("Nope");
            }
        }

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

        if(event.getSource().equals(btnAddMachine)){
            Machine ma = new Machine();
            ma.setModel(this.txtModel.getText());

            try {
                ma.save();
                this.txtModel.setText("");


            } catch (Exception e) {
                System.err.println("Nope");
            }
        }
        if(event.getSource().equals(btnAddCycle)){
            Cycle cy = new Cycle();
            cy.setType(this.txtType.getText());
            cy.setDuration(Integer.parseInt(this.txtDuration.getText()));
            cy.setPrice(Float.parseFloat(this.txtPrice.getText()));


            try {
                cy.save();
                this.txtType.setText("");
                this.txtDuration.setText("");
                this.txtPrice.setText("");


            } catch (Exception e) {
                System.err.println("Nope");
            }
            CycleOnMachine cm = new CycleOnMachine();
            cm.setCycleFk(cy.getId());
            cm.setMachineFk(Integer.parseInt(this.txtMachineIDadd.getText()));

            try {
                cm.save();
            } catch (Exception e) {
                System.out.println("Help me------------------primarykey");
            }
            this.txtMachineIDadd.setText("");
        }

        if(event.getSource().equals(BtnBack2) || event.getSource().equals(BtnBack3) || event.getSource().equals(BtnBack4) || event.getSource().equals(BtnBack5)) {
            Pn1admin.toFront();
        }
    }
    @FXML
    public  void Logout (ActionEvent ev) throws IOException {
        Main.showWindow(getClass(), "../view/Login.fxml", "Login", 700, 500);
        Login.loggedInEmployee=null;
    }
}
