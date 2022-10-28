package com.example.demo2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CusttableController implements Initializable {


    @FXML
    private TableView<returnmodel> Cust_TAB;

    @FXML
    private TableColumn<CustomerRegistrationinfomodel, String> Cust_name;
    @FXML
    private TableColumn<CustomerRegistrationinfomodel, Integer> Cust_Cont;
    @FXML
    private TableColumn<CustomerRegistrationinfomodel, String> Cust_email;
    @FXML
    private TableColumn<CustomerRegistrationinfomodel, String> Cust_Adhar;

    @FXML
    private TableColumn<CustomerRegistrationinfomodel, Integer> Cust_custId;



    ObservableList<returnmodel> listM;

    public void initialize(URL url, ResourceBundle rb) {

        Cust_custId.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_ID"));
        Cust_Adhar.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_ID_PROOF"));
        Cust_email.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_Email"));
        Cust_Cont.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_Ph_NO"));
        Cust_name.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_NAME"));
        // DatabaseConnection connectNow = new DatabaseConnection();
        //Connection connectDB = connectNow.connectDb();

        listM = DatabaseConnection.getData3();
        Cust_TAB.setItems(listM);

    }
    @FXML
    private TextField Cust_id;
    @FXML
    private TextField Cust_name1;
    @FXML
    private TextField Cust_Contact;
    @FXML
    private TextField Cust_email2;
    @FXML
    private TextField Cust_aadhar;
    public void onbackbuttonclick(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        ((Node)(e.getSource())).getScene().getWindow().hide();
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void Onaddbuttonclick(ActionEvent e) throws IOException, SQLException {
        try {
//            Connection connect = DatabaseConnection.connectDb();
            //Creating Connection Object
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.connectDb();

//            String Sql = "INSERT INTO signup (name,mobno,email,username,password) VALUES(?,?,?,?,?)";

            //Preapared Statement
//            PreparedStatement Pstatement = connect.prepareStatement(Sql);
            //Specifying the values of it's parameter
            PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO customer (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_Email, CUSTOMER_Ph_NO, CUSTOMER_ID_PROOF) VALUES(?,?,?,?,?)");
            Pstatement.setString(1, Cust_id.getText());
            Pstatement.setString(2, Cust_name1.getText());
            Pstatement.setString(3, Cust_email2.getText());
            Pstatement.setString(4, Cust_Contact.getText());
            Pstatement.setString(5, Cust_aadhar.getText());
            Pstatement.executeUpdate();

            // After creating Account Login Page Will Appear
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerD.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
//        Parent root = FXMLLoader.load((getClass().getResource("loginpage.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}