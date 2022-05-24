/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirlineTicketBookingSystemGUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author wangx
 */
public class DBManager {
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby://localhost:1527/DataBase; create=true;";
    Connection connection;
    
    public DBManager(){
        establishConnection();
    }

    public void establishConnection() {
        if (this.connection == null){
            try{
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Connection Succesful");
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnection(){
        if(connection == null){
            try{
                connection.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public static void main(String[] args){
        DBManager manager = new DBManager();
        System.out.println(manager.getConnection());
    }
    
    
    
}
