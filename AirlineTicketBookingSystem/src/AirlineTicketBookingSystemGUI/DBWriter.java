/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirlineTicketBookingSystemGUI;

import AirlineTicketBookingSystemGUI.DBManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Xiaofeng Wang
 */
public class DBWriter {
    
    Connection connection;
    private DBManager dbmanager;
    Statement statement;
    
    public DBWriter(){
        
    }
    
    public void addFlightLocation() throws SQLException{
        connection = dbmanager.getConnection();
        statement = dbmanager.connection.createStatement();
        
        statement.executeUpdate("CREATE TABLE Location(location varchar(255)");
        PreparedStatement pstmt = dbmanager.connection.prepareStatement("INSERT INTO Location(Places) VALUES ('Hamilton' , 'Queenstown' , 'Christchurch' ,'Rotorua', 'Wellington', 'Tauranga', 'Stewart Islands', 'Dunedin', 'Palmerston North', 'Whangarei', 'Kaitaia'");
        pstmt.executeUpdate();
    }
    
    public void checkFlightLocation()throws SQLException{
        connection = dbmanager.getConnection();
        statement = dbmanager.connection.createStatement();
        
        
    }
    
    
}
