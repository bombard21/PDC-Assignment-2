package AirlineTicketBookingSystemGUI;

import dataBaseCode.DBManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class flightDataBaseSearch extends JFrame implements ActionListener {

    private static DBManager dbManager;
    private static Statement statement;
    private static Connection connection;
    private JButton searchButton;
    private static JTextField searchField;
    private JLabel searchLabel;
    private static JTextArea searchArea;
    private JFrame frame;
    private String flightDataOutput;

    public flightDataBaseSearch(){
        frame = new JFrame();
        frame.setTitle("Flight Search");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchLabel = new JLabel("Search for a flight");
        searchLabel.setBounds(100,20,200,20);
        frame.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(100,50,200,20);
        frame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(100,100,100,20);
        frame.add(searchButton);
        searchButton.addActionListener(this);

        searchArea = new JTextArea();
        searchArea.setBounds(100,150,200,200);
        frame.add(searchArea);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton){
            dbManager = new DBManager();
            try{
                statement = dbManager.getConnection().createStatement();
                String flightId = flightDataBaseSearch.searchField.getText();
                String sql = "SELECT * FROM TicketData WHERE FlightNumber = '" + flightId + "'";
                ResultSet rs = statement.executeQuery(sql);
                System.out.println(sql);
                //clear the text area
                flightDataBaseSearch.searchArea.setText("");
                if(rs.next()){
                    String flightNumber =  rs.getString("FlightNumber");
                    String arrivalDestination = rs.getString("ArrivalDestination");
                    String departure = rs.getString("Departure");

                    flightDataOutput = ("Flight Number: " + flightNumber + "\n" +"Destination: " + arrivalDestination + "\n" + "Departure: " + departure);
                    searchArea.append(flightDataOutput + "\n");
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
