/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseCode;



import AirlineTicketBookingSystemGUI.LoginPage;
import AirlineTicketBookingSystemGUI.Register;
import AirlineTicketBookingSystemGUI.User;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Xiaofeng Wang
 */
public class DBWriter extends Component {
    private AirlineTicketBookingSystemGUI.Booking booking;
    //    private AirlineTicketBookingSystemGUI.LoginPage loginPage;
//    private AirlineTicketBookingSystemGUI.Register register;
    private AirlineTicketBookingSystemGUI.Ticket ticket;
    Connection connection;
    private DBManager dbmanager;
    Statement statement;

    public DBWriter() {
//        loginPage = new AirlineTicketBookingSystemGUI.LoginPage(this);
//        register = new AirlineTicketBookingSystemGUI.Register(this);

        dbmanager = new DBManager();
        try {
            statement = dbmanager.connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    public void createRegisterDatabase() {
        try {
            //if the database does exist, then create the table
            if (!checkRegisterDatabaseExsistence()) {
                statement.executeUpdate("CREATE TABLE RegisterData(Username varchar(255), Password varchar(255), Email varchar(255))");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database already exists retard");
        }
    }

    private boolean checkRegisterDatabaseExsistence() {
        //check if the database exists
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database does not exist cunt");
        }
        return false;
    }

    public void checkLoginToRegister() {
        try {
            String username = LoginPage.loginpage.userName.getText();
            String password = String.valueOf(LoginPage.loginpage.password.getPassword());

            System.out.println(username);
            System.out.println(password);

            // fix: make sure you're actually reading the right username and password fields
            // fix: make sure the username and password fields actually get saved to the database

            //check if the username and password is in the database
            String sql = "SELECT * FROM RegisterData WHERE Username = '" + username + "' AND Password = '" + password + "'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("Username").equals(username) && rs.getString("Password").equals(password)) {
                    //if the username and password is in the database, then login
                    LoginPage.loginpage.setVisible(false);
                    User user = new User();
                    user.setVisible(true);
                }
            } else if (!rs.next()) {
                //if the username and password is not in the database
                JOptionPane.showMessageDialog(null, "Your account was not found. Please register an account.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("ur details are not in the fucking database");
        }
    }

    public void addRegisterInputToDB() {
        try {
            String username = Register.register.username.getText();
            String password = String.valueOf(Register.register.password.getPassword());
            String email = Register.register.email.getText();
            String sql = "INSERT INTO RegisterData VALUES('" + username + "', '" + password + "', '" + email + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error:  " + e);
            System.out.println("ur details are being fucking added calm down");
        }
    }

    public void createLocationDatabase() {
        try {
            //if the database does not exist, then create it
            if (!checkLocationDatabaseExsistence()) {
                statement.executeUpdate("CREATE TABLE LocationData(LocationName VARCHAR(255)");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database already exists");
        }

    }

    public boolean checkLocationDatabaseExsistence() {
        try {
            String sql = "SELECT * FROM LocationData";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database does not exist yet");
        }
        return false;
    }

    public void addLocationsToDatabase(){
        
    }
}







