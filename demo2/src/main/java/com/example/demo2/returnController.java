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

public class returnController{
    @FXML
    private TableView<returnmodel> Rent_tab;

    @FXML
    private TableColumn<returnmodel, Integer> CustomerId;
    @FXML
    private TableColumn<returnmodel, Integer> RegistrationId;
    @FXML
    private TableColumn<returnmodel, Integer> No_of_Days;
    @FXML
    private TableColumn<returnmodel, Integer> T_amount;

    @FXML
    private TableColumn<returnmodel, String> Rent_DOP;

    ObservableList<returnmodel> listM;
    @FXML
    private TextField Return_regid;
    @FXML
    private TextField Return_custid;
    @FXML
    private TextField Return_days;
    @FXML
    private TextField Return_rent;
    @FXML
    private TextField Return_fine;
    @FXML
    private TextField Return_Tamount;

    public void onbackbuttonclick(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        ((Node) (e.getSource())).getScene().getWindow().hide();
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }



    public void Onreturnbuttonclick(ActionEvent e) throws IOException{
        try {
//            Connection connect = DatabaseConnection.connectDb();
            //Creating Connection Object
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.connectDb();

//            String Sql = "INSERT INTO signup (name,mobno,email,username,password) VALUES(?,?,?,?,?)";

            //Preapared Statement
//            PreparedStatement Pstatement = connect.prepareStatement(Sql);
            //Specifying the values of it's parameter
            PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO return (REGISTRATION_NO, CUSTOMER_ID, NO_DAYS, RENT, FINE, TOTAL_AMOUNT) VALUES(?,?,?,?,?,?)");
            Pstatement.setString(1, Return_regid.getText());
            Pstatement.setString(2, Return_custid.getText());
            Pstatement.setString(3, Return_days.getText());
            Pstatement.setString(4, Return_rent.getText());
            Pstatement.setString(5, Return_fine.getText());
            Pstatement.setString(6, Return_Tamount.getText());
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
   /*
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.connectDb();

        PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO return_car (REGISTRATION_NO, CUSTOMER_ID, NO_DAYS, RENT, FINE, TOTAL_AMOUNT) VALUES(?,?,?,?,?,?)");
        Pstatement.setString(1, Return_regid.getText());
        Pstatement.setString(2, Return_custid.getText());
        Pstatement.setString(3, Return_days.getText());
        Pstatement.setString(4, Return_rent.getText());
        Pstatement.setString(5, Return_fine.getText());
        Pstatement.setString(6, Return_Tamount.getText());
        Pstatement.executeUpdate();
    }
    }
*/
