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


public class RegistrationTableController implements Initializable {


    @FXML
    private TableView<CarRegistrationinfomodel> Reg_tb;

    @FXML
    private TableColumn<CarRegistrationinfomodel, Integer> Tb_RegId;
    @FXML
    private TableColumn<CarRegistrationinfomodel, String> Tb_ModNa;
    @FXML
    private TableColumn<CarRegistrationinfomodel, String> Tb_Num;
    @FXML
    private TableColumn<CarRegistrationinfomodel, String> Tb_Rent;

    @FXML
    private TableColumn<CarRegistrationinfomodel, String> Tb_ModelColour;



    ObservableList<CarRegistrationinfomodel> listM;

    public void initialize(URL url, ResourceBundle rb) {

        Tb_RegId.setCellValueFactory(new PropertyValueFactory<>("REGISTRATION_NO"));
        Tb_ModNa.setCellValueFactory(new PropertyValueFactory<>("MODEL_NAME"));
        Tb_Num.setCellValueFactory(new PropertyValueFactory<>("MODEL_NO"));
        Tb_ModelColour.setCellValueFactory(new PropertyValueFactory<>("MODEL_COLOUR"));
        Tb_Rent.setCellValueFactory(new PropertyValueFactory<>("RENT_PER_DAY"));
        // DatabaseConnection connectNow = new DatabaseConnection();
        //Connection connectDB = connectNow.connectDb();

        listM = DatabaseConnection.getData();
        Reg_tb.setItems(listM);

    }


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

        public void onbackbuttonclick(ActionEvent e) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }

        public void Onsubmitbuttonclick(ActionEvent e) throws IOException {
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
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("carregistration.fxml"));
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

