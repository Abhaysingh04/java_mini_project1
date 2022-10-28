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

public class RentalTableController implements Initializable {


    @FXML
    private TableView<Rentalinfomodel> Rent_tab;

    @FXML
    private TableColumn<Rentalinfomodel, Integer> Rent_Custid;
    @FXML
    private TableColumn<Rentalinfomodel, Integer> Rent_Regid;
    @FXML
    private TableColumn<Rentalinfomodel, Integer> Rent_Days;
    @FXML
    private TableColumn<Rentalinfomodel, Integer> Rent_rent;

    @FXML
    private TableColumn<Rentalinfomodel, String> Rent_DOP;



    ObservableList<Rentalinfomodel> listM;

    public void initialize(URL url, ResourceBundle rb) {

        Rent_Regid.setCellValueFactory(new PropertyValueFactory<>("REGISTRATION_ID"));
        Rent_Custid.setCellValueFactory(new PropertyValueFactory<>("CUSTOMER_ID"));
        Rent_DOP.setCellValueFactory(new PropertyValueFactory<>("DATE"));
        Rent_Days.setCellValueFactory(new PropertyValueFactory<>("NO_OF_DAYS"));
        Rent_rent.setCellValueFactory(new PropertyValueFactory<>("TOTAL_RENT"));
        // DatabaseConnection connectNow = new DatabaseConnection();
        //Connection connectDB = connectNow.connectDb();

        listM = DatabaseConnection.getData2();
        Rent_tab.setItems(listM);

    }
    @FXML
    private TextField tx_regId;
    @FXML
    private TextField tx_custid;
    @FXML
    private TextField tx_date;
    @FXML
    private TextField tx_days;
    @FXML
    private TextField tx_amount;
    public void onbackbuttonclick(ActionEvent e) throws  IOException{
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
            PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO rental (REGISTRATION_ID, CUSTOMER_ID, DATE, NO_OF_DAYS, TOTAL_RENT) VALUES(?,?,?,?,?)");
            Pstatement.setString(1, tx_regId.getText());
            Pstatement.setString(2, tx_custid.getText());
            Pstatement.setString(3, tx_date.getText());
            Pstatement.setString(4, tx_days.getText());
            Pstatement.setString(5, tx_amount.getText());
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