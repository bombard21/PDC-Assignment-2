/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseCode;



import AirlineTicketBookingSystemGUI.*;
import AirlineTicketBookingCode.Trip;

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
//    private AirlineTicketBookingSystemGUI.Booking booking;
//    private AirlineTicketBookingSystemGUI.Ticket ticket;

    private AirlineTicketBookingCode.Trip trip;
    Connection connection;
    private DBManager dbmanager;
    Statement statement;

    public DBWriter() {

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
        }
    }

    public void addRegisterInputToDB() {
        try {
            String username = Register.registering.username.getText();
            String password = String.valueOf(Register.registering.password.getPassword());
            String email = Register.registering.email.getText();
            System.out.println("USERNAME:"+ username + " PASSWORD:" + password + " EMAIL:" + email);
            String sql = "INSERT INTO RegisterData (Username, Password, Email) VALUES ('" + username + "', '" + password + "', '" + email + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error:  " + e);
        }
    }

    public void createBookingDatabase() {
        try {
            if (!checkBookingDatabaseExsistence()) {
                statement.executeUpdate("CREATE TABLE BookingData(Name varchar(255), Destination varchar(255), DOB varchar(255))");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database already");
        }
    }

    public boolean checkBookingDatabaseExsistence() {
        //check if the database exists
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM BookingData");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public void addBookingData(){
        try{
            String name = Booking.booking.firstNameTextField.getText() + Booking.booking.lastNameTextField.getText();
            String destination = Booking.booking.destinationTextField.getText();
            String dob = Booking.booking.dobTextField.getText();
            String sql = "INSERT INTO BookingData (Name, Destination, DOB) VALUES ('" + name + "', '" + destination + "', '" + dob + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void createTicketDatabase(){
        try{
            if (!checkTicketDatabaseExsistence()){
                statement.executeUpdate("CREATE TABLE TicketData(Name varchar(255), ArrivalDestination varchar(255), Departure varchar(255), FlightNumber varchar(255), BoardingTime varchar(255), Gate varchar(255), Date date, SeatNumber varchar(255))");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println("database already");
        }
    }

    private boolean checkTicketDatabaseExsistence() {
        //check if the database exists
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM TicketData");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public void addTicketData(){
        try{
            String flightNumber = trip.createFlightNumber();
            String boardingTime = trip.createDepartureTime();
            String gate = trip.createGateNumber();
            String flightTime = trip.setArrivalTime();
            String name = Booking.booking.firstNameTextField.getText() + Booking.booking.lastNameTextField.getText();
            String destination = Booking.booking.destinationTextField.getText();

            String sql = "INSERT INTO TicketData (name, ArrivalDestination, Departure, FlightNumber, BoardingTime, Gate, Date, SeatNumber) VALUES ('" + name + "', '" + destination + "', '" + flightTime + "', '" + flightNumber + "', '" + boardingTime + "', '" + gate + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void searchTicketDatabase(){
        try{
            String nameID = Ticket.ticket.jTextField1.getText();
            String sql = "SELECT * FROM TicketData WHERE Name = '" + nameID + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                Ticket.ticket.jTextField2.setText(rs.getString("Name"));
                Ticket.ticket.jTextField2.setText(rs.getString("ArrivalDestination"));
                Ticket.ticket.jTextField2.setText(rs.getString("Departure"));
                Ticket.ticket.jTextField2.setText(rs.getString("FlightNumber"));
                Ticket.ticket.jTextField2.setText(rs.getString("BoardingTime"));
                Ticket.ticket.jTextField2.setText(rs.getString("Gate"));
                Ticket.ticket.jTextField2.setText(rs.getString("Date"));
                Ticket.ticket.jTextField2.setText(rs.getString("SeatNumber"));
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

}







