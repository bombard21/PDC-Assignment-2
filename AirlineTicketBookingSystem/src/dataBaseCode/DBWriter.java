/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseCode;

import dataBaseCode.DBManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Xiaofeng Wang
 */
public class DBWriter {
    private AirlineTicketBookingSystemGUI.LoginPage loginPage;
    Connection connection;
    private DBManager dbmanager;
    Statement statement;
    
    public DBWriter(){
        dbmanager = new DBManager();
    }
    
    public void addFlightLocation() throws SQLException{
        connection = dbmanager.getConnection();
        statement = dbmanager.connection.createStatement();
        
        statement.executeUpdate("CREATE TABLE Location(location varchar(255)");
        PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO Location(Places) VALUES ('Hamilton' , 'Queenstown' , 'Christchurch' ,'Rotorua', 'Wellington', 'Tauranga', 'Stewart Islands', 'Dunedin', 'Palmerston North', 'Whangarei', 'Kaitaia'");
        pstmt.executeUpdate();
    }

    public void checkExsistence(){
        //check if the database exist
        //if not, create the database
        try{
            DatabaseMetaData meta = dbmanager.connection.getMetaData();
            ResultSet rs = meta.getTables(null, null, "Location", null);
            if(!rs.next()){
                addFlightLocation();
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void userData(){
        //grab the text from the text fields
        //insert the data into the database
        try{
            String userName = loginPage.userName.getText();
            String password = String.valueOf(loginPage.password.getPassword());
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        loginPage.userName.getText();
    }
    
    
}
