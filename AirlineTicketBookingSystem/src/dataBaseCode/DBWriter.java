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
            System.out.println("database does not exist");
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

    public void searchTicketDatabase(){
        try{
            String nameID = Ticket.ticket.jTextField1.getText();
            String sql = "SELECT * FROM TicketData WHERE FirstName = '" + nameID + "'";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(sql);
            //clear the text area
            if (rs.next()){
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String arrivalDestination = rs.getString("ArrivalDestination");
                String departure = rs.getString("Departure");
                String flightNumber = rs.getString("FlightNumber");
                String flightTime = rs.getString("FlightTime");
                String boardingTime = rs.getString("BoardingTime");
                String gate = rs.getString("Gate");
                String seatNumber = rs.getString("SeatNumber");

                String output = ("firstName: " + firstName + lastName + "\n" +"Arrival Destination: " + arrivalDestination + "\n" + "Departure: " + departure + "\n"+ "Flight Time: " + flightTime + "hours" + "\n" + "Flight Number: " + flightNumber + "\n" + "Boarding Time: " + boardingTime + "\n" + "Gate: " + gate + "\n" + "Seat Number: " + seatNumber);
                Ticket.ticket.ticketDataArea.append(output);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void searchFlightDataBase(){
        try{
            String flightNumber = flightData.flightData.flightNumber.getText();
            String sql = "SELECT * FROM TicketData WHERE FlightNumber = '" + flightNumber + "'";
            ResultSet rs = statement.executeQuery(sql);
            //clear the text area
            flightData.flightData.flightDataArea.setText("");
            if(rs.next()){
                String arrivalDestination = rs.getString("ArrivalDestination");
                String departure = rs.getString("Departure");

                String output = ("Arrival Destination: " + arrivalDestination + "\n" + "Departure: " + departure);
                flightData.flightData.flightDataArea.append(output);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}







