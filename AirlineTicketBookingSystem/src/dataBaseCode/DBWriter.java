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

//    private AirlineTicketBookingCode.Trip trip;
    Connection connection;
     DBManager dbmanager;
    Statement statement;
    String ticketDataOutput;
    String flightDataOutput;

    public DBWriter() {

        dbmanager = new DBManager();
        try {
            statement = dbmanager.connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    /**
     * If the database does not exist, then create the database
     */
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

    /**
     * It checks if the database exists
     *
     * @return A boolean value.
     */
    private boolean checkRegisterDatabaseExsistence() {
        //check if the database exists
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("database does not exist");
        }
        return false;
    }

    /**
     * It checks if the username and password are in the database, and if they are, it logs the user in
     */
    public void checkLoginToRegister() {
        try {
            String username = LoginPage.loginpage.userName.getText();
            String password = String.valueOf(LoginPage.loginpage.password.getPassword());

            System.out.println(username);
            System.out.println(password);

            // fix: make sure you're actually reading the right username and password fields
            // fix: make sure the username and password fields actually get saved to the database

            //check if the username and password is in the database
            String sql = "SELECT * FROM RegisterData WHERE Username = \'" + username + "\' AND Password = \'" + password + "\'";
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

    /**
     * It takes the text from the username, password, and email fields in the Register class and inserts them into the
     * RegisterData table in the database
     */
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


    /**
     * This function creates a table in the database if the table does not already exist
     */
    public void createTicketDatabase(){
        try{
            if (!checkTicketDatabaseExsistence()){
                statement.executeUpdate("CREATE TABLE TicketData(FirstName varchar(255),LastName varchar(255), ArrivalDestination varchar(255), Departure varchar(255), FlightTime varchar(255), FlightNumber varchar(255), BoardingTime varchar(255), Gate varchar(255), SeatNumber varchar(255))");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println("database already");
        }
    }

    /**
     * It checks if the database exists by trying to select all the data from the database. If it can't find the database,
     * it will throw an exception. If it can find the database, it will return true
     *
     * @return A boolean value.
     */
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

    /**
     * This function takes the data from the text fields in the booking class and adds it to the database
     */
    public void addTicketData(){
        try{
            String firstName = Booking.booking.firstNameTextField.getText();
            String lastName = Booking.booking.lastNameTextField.getText();
            String destination = Booking.booking.destinationTextField.getText();
            String flightNumber = Trip.trip.createFlightNumber();
            String boardingTime = Trip.trip.createDepartureTime();
            String gate = Trip.trip.createGateNumber();
            String flightTime = Trip.trip.setArrivalTime();
            String seatNumber = SeatPicker.seat.getText();
            String departure = "Auckland";
            System.out.println("FirstName: " + firstName + " LastName: " + lastName + " Destination: " + destination + "FlightTime: " + flightTime + " FlightNumber: " + flightNumber + " BoardingTime: " + boardingTime + " Gate: " + gate + " FlightTime: " + flightTime + " SeatNumber: " + seatNumber);

            String sql = "INSERT INTO TicketData (FirstName, LastName , ArrivalDestination, Departure, FlightTime, FlightNumber, BoardingTime, Gate, SeatNumber) VALUES ('" + firstName + "', '" + lastName +"', '"+ destination + "', '" + departure + "','" + flightTime + "', '" + flightNumber + "', '" + boardingTime + "', '" + gate + "','"+seatNumber+"')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    /**
     * This function is used to search the database for a specific ticket
     */
}







