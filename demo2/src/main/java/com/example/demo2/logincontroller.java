package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logincontroller {


        @FXML
        private TextField usernameTextField;
        @FXML
        private PasswordField passwordField;
        @FXML
        private Label invalidlogin;
        @FXML
        private Button b_Signin;

        private Stage stage;
        private Scene scene;

        public void Signin(ActionEvent event) throws IOException, java.sql.SQLException {
            String Sql ="SELECT * FROM signup WHERE username = ? AND password = ?";

            Connection connect = DatabaseConnection.connectDb();

            PreparedStatement prepare = connect.prepareStatement(Sql);
            prepare.setString(1, usernameTextField.getText());
            prepare.setString(2, passwordField.getText());

            ResultSet result = prepare.executeQuery();
            Alert alert;

            if(usernameTextField.getText().isEmpty()||passwordField.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText("null");
                alert.setContentText("please fill all the details");

            }else if (result.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION MESSAGE");
                alert.setHeaderText("null");
                alert.setContentText("successfully login");
                //b_Signin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText("null");
                alert.setContentText("wrong username/password");
            }


        }

        public void Signup1(ActionEvent event) {
            try {
                FXMLLoader load1 = new FXMLLoader(getClass().getResource("Signup.fxml"));
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent root = load1.load();
                Stage scene1 =new Stage();
                scene1.setScene(new Scene((root)));
                scene1.show();
            }
            catch (Exception ep){
                ep.printStackTrace();
 }
    }
    public void Signup(ActionEvent event) {
        try {
            Parent NextParent = FXMLLoader.load(getClass().getResource("newuser.fxml"));
            Scene NextScene = new Scene(NextParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(NextScene);
            window.show();
        }
        catch (Exception ep){
            ep.printStackTrace();
        }
    }
    DatabaseConnection connectnow = new DatabaseConnection();
    Connection connectdb = connectnow.connectDb();
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_mobile;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_pass;
    @FXML
    private TextField tf_user;
    public void onSignUpButtonClick(ActionEvent e) throws IOException, SQLException {
        try {
//            Connection connect = DatabaseConnection.connectDb();
            //Creating Connection Object
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.connectDb();
            String name=tf_name.getText();

//            String Sql = "INSERT INTO signup (name,mobno,email,username,password) VALUES(?,?,?,?,?)";

            //Preapared Statement
//            PreparedStatement Pstatement = connect.prepareStatement(Sql);
            //Specifying the values of it's parameter
            PreparedStatement Pstatement = connectdb.prepareStatement("INSERT INTO signup (name,mobno,email,username,password) VALUES(?,?,?,?,?)");
            Pstatement.setString(1, name);
            Pstatement.setString(2, tf_mobile.getText());
            Pstatement.setString(3, tf_email.getText());
            Pstatement.setString(4, tf_user.getText());
            Pstatement.setString(5, tf_pass.getText());
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
    public void Signin1(ActionEvent e) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
//        Parent root = FXMLLoader.load((getClass().getResource("main.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    public void Customer(ActionEvent e) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerD.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

//        Parent root = FXMLLoader.load((getClass().getResource("CustomerD.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    public void Car(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("carregistration.fxml"));
        ((Node)(e.getSource())).getScene().getWindow().hide();
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void Rental(ActionEvent e) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Rent.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
//        Parent root = FXMLLoader.load((getClass().getResource("Rent.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    public void Return(ActionEvent e) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Return.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

//        Parent root = FXMLLoader.load((getClass().getResource("Return.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    public void onlogoutbuttonclicked(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
        ((Node)(e.getSource())).getScene().getWindow().hide();
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}

