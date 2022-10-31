package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


    public static Connection connectDb(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_mini", "root", "");

            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failure!");
        }

        return null;
}

    // For Car Registration

    public static ObservableList<CarRegistrationinfomodel> getData() {
        ObservableList<CarRegistrationinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select * from registration");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new CarRegistrationinfomodel(rs.getInt("REGISTRATION_NO"), rs.getString("MODEL_NAME"), rs.getString("MODEL_COLOUR"),rs.getString("MODEL_NO"), rs.getString("RENT_PER_DAY")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
}
    //For Customer Registration
    public static ObservableList<CustomerRegistrationinfomodel> getData1() {
        ObservableList<CustomerRegistrationinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new CustomerRegistrationinfomodel(rs.getString("CUSTOMER_NAME"), rs.getInt("CUSTOMER_Ph_NO"), rs.getString("CUSTOMER_Email"), rs.getString("CUSTOMER_ID_PROOF"), rs.getInt("CUSTOMER_ID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }


    // For Rental Page
    public static ObservableList<Rentalinfomodel> getData2() {
        ObservableList<Rentalinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select * from rental");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new Rentalinfomodel(rs .getInt("REGISTRATION_ID"), rs.getInt("CUSTOMER_ID"), rs.getString("DATE"), rs.getInt("NO_OF_DAYS"), rs.getInt("TOTAL_RENT")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }
    public static ObservableList<returnmodel> getData3(){
        ObservableList<returnmodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select * from return");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new returnmodel(rs.getInt("REGISTRATION_NO"),rs.getInt("CUSTOMER_ID"),rs.getInt("Total_Amount"),rs.getInt("NO_DAYS"), rs.getString("DOP")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
