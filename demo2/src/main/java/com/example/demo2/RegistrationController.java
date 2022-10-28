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

public class RegistrationController {
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_number;
    @FXML
    private TextField tf_colour;
    @FXML
    private TextField tf_rent;
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
            PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO registration (REGISTRATION_NO,MODEL_NAME,MODEL_NO,MODEL_COLOUR,RENT_PER_DAY) VALUES(?,?,?,?,?)");
            Pstatement.setString(1, tf_id.getText());
            Pstatement.setString(2, tf_name.getText());
            Pstatement.setString(3, tf_number.getText());
            Pstatement.setString(4, tf_colour.getText());
            Pstatement.setString(5, tf_rent.getText());
            Pstatement.executeUpdate();

            // After creating Account Login Page Will Appear
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
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
