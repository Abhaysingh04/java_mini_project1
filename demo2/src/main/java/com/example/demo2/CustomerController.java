package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {
    @FXML
    private TextField Cust_id;
    @FXML
    private TextField Cust_name;
    @FXML
    private TextField Cust_Contact;
    @FXML
    private TextField Cust_email;
    @FXML
    private TextField Cust_aadhar;
    public void onbackbuttonclick(ActionEvent e) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        ((Node)(e.getSource())).getScene().getWindow().hide();
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void Onsubmitbuttonclick(ActionEvent e) throws IOException, SQLException {
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
            Pstatement.setString(2, Cust_name.getText());
            Pstatement.setString(3, Cust_email.getText());
            Pstatement.setString(4, Cust_Contact.getText());
            Pstatement.setString(5, Cust_aadhar.getText());
            Pstatement.executeUpdate();

            // After creating Account Login Page Will Appear
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
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