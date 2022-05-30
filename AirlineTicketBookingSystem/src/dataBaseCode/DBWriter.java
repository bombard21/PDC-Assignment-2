/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseCode;


import AirlineTicketBookingSystemGUI.Ticket;

import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Xiaofeng Wang
 */
public class DBWriter {
    private AirlineTicketBookingSystemGUI.Booking booking;
    private AirlineTicketBookingSystemGUI.LoginPage loginPage;
    private AirlineTicketBookingSystemGUI.Register register;
    private AirlineTicketBookingSystemGUI.User user;
    private Ticket ticket;
    Connection connection;
    private DBManager dbmanager;
    Statement statement;
    
    public DBWriter(){
        dbmanager = new DBManager();
    }
    
    public void addFlightLocationData() throws SQLException{
        connection = dbmanager.getConnection();
        statement = dbmanager.connection.createStatement();
        
        statement.executeUpdate("CREATE TABLE Location(location varchar(255)");
        PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO Location(Places) VALUES ('Hamilton' , 'Queenstown' , 'Christchurch' ,'Rotorua', 'Wellington', 'Tauranga', 'Stewart Islands', 'Dunedin', 'Palmerston North', 'Whangarei', 'Kaitaia'");
        pstmt.executeUpdate();
    }

    public boolean checkFlightLocationData(){
        //check if the data entered is already in the database
        try{
            String location = booking.destinationTextField.getText();
            ResultSet rs = statement.executeQuery("SELECT * FROM Location WHERE Places = '" + location + "'");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return false;
    }

    //when the user enter data into the login text field it will check if its in the register data base if its not it will as the user to register
    public boolean checkLoginData(){
        try{
            String userUsername = loginPage.userName.getText();
            String userPassword = String.valueOf(loginPage.password.getPassword());
            //check if the data entered is already in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData WHERE Username = '" + userUsername + "' AND Password = '" + userPassword + "'");
            if(rs.next()){
                return true;

            }else if(!rs.next()){
                JOptionPane.showMessageDialog(null, "You have not registered yet, please register");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return false;
    }


    public void addRegisterData(){
        //grab the text from the text fields
        //insert the data into the database
        try{
            String registerUsername = register.username.getText();
            String registerPassword = String.valueOf(register.password.getPassword());
            String registerEmail = register.email.getText();

            if(!checkRegisterDataExsistence(register.username, register.password, register.email)){
                PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO RegisterData(FirstName, LastName, Email) VALUES (?, ?, ?)");
                pstmt.setString(1, registerUsername);
                pstmt.setString(2, registerPassword);
                pstmt.setString(3, registerEmail);
            }

        }catch (Exception e){
            System.out.println("Error: " + e);
        }

    }

    public boolean checkRegisterDataExsistence(JTextField userName, JPasswordField password, JTextField email){
        //check if the data entered is already in the database
        //if not, insert the data into the database
        try{
            String userUsername = register.username.getText();
            String userPassword = String.valueOf(register.password.getPassword());
            String userEmail = register.email.getText();
            ResultSet rs = statement.executeQuery("SELECT * FROM RegisterData WHERE UserName = '" + userUsername + "' AND Password = '" + userPassword + "' AND Email = '" + userEmail + "'");
            if(rs.next()){
                return rs.getString("UserName").equals(userUsername) && rs.getString("Password").equals(userPassword) && rs.getString("Email").equals(userEmail);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return false;
    }

    public void addTicketData(){

    }
}
