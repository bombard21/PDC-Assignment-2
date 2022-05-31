/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseCode;



import AirlineTicketBookingSystemGUI.LoginPage;
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
    private AirlineTicketBookingSystemGUI.Register register;
    private AirlineTicketBookingSystemGUI.Ticket ticket;
    Connection connection;
    private DBManager dbmanager;
    Statement statement;
    
    public DBWriter(){
//        loginPage = new AirlineTicketBookingSystemGUI.LoginPage(this);
        register = new AirlineTicketBookingSystemGUI.Register(this);

        dbmanager = new DBManager();
        try{
            statement = dbmanager.connection.createStatement();
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
    
//    public void addFlightLocationData() throws SQLException{
//        connection = dbmanager.getConnection();
//        statement = dbmanager.connection.createStatement();
//
//        statement.executeUpdate("CREATE TABLE Location(location varchar(255)");
//        PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO Location(Places) VALUES ('Hamilton' , 'Queenstown' , 'Christchurch' ,'Rotorua', 'Wellington', 'Tauranga', 'Stewart Islands', 'Dunedin', 'Palmerston North', 'Whangarei', 'Kaitaia'");
//        pstmt.executeUpdate();
//    }
//
//    public boolean checkFlightLocationData(){
//        //check if the data entered is already in the database
//        try{
//            String location = booking.destinationTextField.getText();
//            ResultSet rs = statement.executeQuery("SELECT * FROM Location WHERE Places = '" + location + "'");
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//        return false;
//    }
//
//    //when the user enter data into the login text field it will check if its in the register data base if its not it will as the user to register
//    public boolean checkLoginData(){
//        try{
//            String userUsername = loginPage.userName.getText();
//            String userPassword = String.valueOf(loginPage.password.getPassword());
//            //check if the data entered is already in the database
//            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData WHERE Username = '" + userUsername + "' AND Password = '" + userPassword + "'");
//            if(rs.next()){
//                return true;
//            }else if(!rs.next()){
//                JOptionPane.showMessageDialog(this, "You have not registered yet, please register");
//            }
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//        return false;
//    }
//
//
//    public void addRegisterData(){
//        //grab the text from the text fields
//        //insert the data into the database
//        try{
//            String registerUsername = register.username.getText();
//            String registerPassword = String.valueOf(register.password.getPassword());
//            String registerEmail = register.email.getText();
//
//            //create the table if it doesnt exist
//            statement.executeUpdate("CREATE TABLE RegisterData(Username varchar(255), Password varchar(255), Email varchar(255))");
//            //insert the data into the table
//
//            if(!checkRegisterDataExsistence(register.username, register.password, register.email)){
//                PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO RegisterData(FirstName, LastName, Email) VALUES (?, ?, ?)");
//                pstmt.setString(1, registerUsername);
//                pstmt.setString(2, registerPassword);
//                pstmt.setString(3, registerEmail);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//
//    }
//
//    public boolean checkRegisterDataExsistence(JTextField userName, JPasswordField password, JTextField email){
//        //check if the data entered is already in the database
//        //if not, insert the data into the database
//        try{
//            String userUsername = register.username.getText();
//            String userPassword = String.valueOf(register.password.getPassword());
//            String userEmail = register.email.getText();
//            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData WHERE UserName = '" + userUsername + "' AND Password = '" + userPassword + "' AND Email = '" + userEmail + "'");
//            if(rs.next()){
//                return rs.getString("UserName").equals(userUsername) && rs.getString("Password").equals(userPassword) && rs.getString("Email").equals(userEmail);
//            }
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//        return false;
//    }
//
//    public void addBookingData(){
//        //grab the text from the text fields
//        //insert the data into the database
//        try{
//            String bookingfirstName = booking.firstNameTextField.getText();
//            String bookinglastName = booking.lastNameTextField.getText();
//            String bookingDOB = booking.dobTextField.getText();
//
//            //create the table if it doesnt exist
//            statement.executeUpdate("CREATE TABLE BookingData(FirstName varchar(255), LastName varchar(255), DOB varchar(255))");
//
//            if(!checkBookingDataExsistence(booking.firstNameTextField, booking.lastNameTextField, booking.dobTextField, booking.destinationTextField)){
//                PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO BookingData(FirstName, LastName, DOB) VALUES (?, ?, ?)");
//                pstmt.setString(1, bookingfirstName);
//                pstmt.setString(2, bookinglastName);
//                pstmt.setString(3, bookingDOB);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//    }
//
//    private boolean checkBookingDataExsistence(JTextField firstNameTextField, JTextField lastNameTextField, JTextField dobTextField, JTextField destinationTextField) {
//        //check if the data entered is already in the database
//        //if not, insert the data into the database
//        try{
//            String bookingfirstName = booking.firstNameTextField.getText();
//            String bookinglastName = booking.lastNameTextField.getText();
//            String bookingDOB = booking.dobTextField.getText();
//            ResultSet rs = statement.executeQuery("SELECT * FROM BookingData WHERE FirstName = '" + bookingfirstName + "' AND LastName = '" + bookinglastName + "' AND DOB = '" + bookingDOB + "'");
//            if(rs.next()){
//                return rs.getString("FirstName").equals(bookingfirstName) && rs.getString("LastName").equals(bookinglastName) && rs.getString("DOB").equals(bookingDOB);
//            }
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//        return false;
//    }
//
//    public void addTicketData(){
//        //grab the text from the text fields
//        //insert the data into the database
//        try{
//            String ticketFullName = ticket.Name.getText();
//            String ticketArrivalDestination = ticket.arrivalDestination.getText();
//            String ticketDepartureDestination = ticket.departure.getText();
//            String ticketFlightNumber = ticket.flightNumber.getText();
//            String ticketSeatNumber = ticket.seatNumber.getText();
//            String ticketDate = ticket.date.getText();
//            String ticketTime = ticket.time.getText();
//
//            //create the table if it doesnt exist
//            statement.executeUpdate("CREATE TABLE TicketData(FullName varchar(255), ArrivalDestination varchar(255), DepartureDestination varchar(255), FlightNumber varchar(255), SeatNumber varchar(255), Date varchar(255), Time varchar(255))");
//
//
//            if(!checkTicketDataExsistence(ticket.Name, ticket.arrivalDestination, ticket.departure, ticket.flightNumber, ticket.seatNumber, ticket.date, ticket.time)){
//                PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO TicketData(FullName, ArrivalDestination, DepartureDestination, FlightNumber, SeatNumber, Date, Time) VALUES (?, ?, ?, ?, ?, ?, ?)");
//                pstmt.setString(1, ticketFullName);
//                pstmt.setString(2, ticketArrivalDestination);
//                pstmt.setString(3, ticketDepartureDestination);
//                pstmt.setString(4, ticketFlightNumber);
//                pstmt.setString(5, ticketSeatNumber);
//                pstmt.setString(6, ticketDate);
//                pstmt.setString(7, ticketTime);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//    }
//
//    private boolean checkTicketDataExsistence(JTextField name, JTextField arrivalDestination, JTextField departure, JTextField flightNumber, JTextField seatNumber, JTextField date, JTextField time) {
//        //check if the data entered is already in the database
//        //if not, insert the data into the database
//        try{
//            String ticketFullName = ticket.Name.getText();
//            String ticketArrivalDestination = ticket.arrivalDestination.getText();
//            String ticketDepartureDestination = ticket.departure.getText();
//            String ticketFlightNumber = ticket.flightNumber.getText();
//            String ticketSeatNumber = ticket.seatNumber.getText();
//            String ticketDate = ticket.date.getText();
//            String ticketTime = ticket.time.getText();
//            ResultSet rs = statement.executeQuery("SELECT * FROM TicketData WHERE FullName = '" + ticketFullName + "' AND ArrivalDestination = '" + ticketArrivalDestination + "' AND DepartureDestination = '" + ticketDepartureDestination + "' AND FlightNumber = '" + ticketFlightNumber + "' AND SeatNumber = '" + ticketSeatNumber + "' AND Date = '" + ticketDate + "' AND Time = '" + ticketTime + "'");
//            if(rs.next()){
//                return rs.getString("FullName").equals(ticketFullName) && rs.getString("ArrivalDestination").equals(ticketArrivalDestination) && rs.getString("DepartureDestination").equals(ticketDepartureDestination) && rs.getString("FlightNumber").equals(ticketFlightNumber) && rs.getString("SeatNumber").equals(ticketSeatNumber) && rs.getString("Date").equals(ticketDate) && rs.getString("Time").equals(ticketTime);
//            }
//        }catch (Exception e){
//            System.out.println("Error: " + e);
//        }
//        return false;
//    }

    public void createRegisterDatabase(){
        try{
            //if the database does exist, then create the table
            if(!checkRegisterDatabaseExsistence()){
                statement.executeUpdate("CREATE TABLE RegisterData(Username varchar(255), Password varchar(255), Email varchar(255))");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println("database already exists retard");
        }
    }

    private boolean checkRegisterDatabaseExsistence() {
        //check if the database exists
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData");
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println("database does not exist cunt");
        }
        return false;
    }

    public void checkLoginToRegister(){
        try{
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
            if(rs.next() ){
                if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password)){
                    //if the username and password is in the database, then login
                    LoginPage.loginpage.setVisible(false);
                    User user = new User();
                    user.setVisible(true);
                }
            }else if(!rs.next()){
                //if the username and password is not in the database
                JOptionPane.showMessageDialog(null, "Your account was not found. Please register an account.");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
            System.out.println("ur details are not in the fucking database");
        }
    }

    public void addRegisterInputToDB(){
        try{
            String username = register.username.getText();
            String password = String.valueOf(register.password.getPassword());
            String email = register.email.getText();
            String sql = "INSERT INTO RegisterData VALUES('" + username + "', '" + password + "', '" + email + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println("Error:  " + e);
            System.out.println("ur details are being fucking added calm down");
        }
    }






}
