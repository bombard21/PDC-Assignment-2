package AirlineTicketBookingSystemGUI;

import dataBaseCode.DBManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ticketDataBaseSearch extends JFrame implements ActionListener {
    private static dataBaseCode.DBManager dbManager;
    private static Statement stmt;
    private static Connection conn;
    private JButton search;
    private static JTextField searchField;
    private JLabel searchLabel;
    private static JTextArea result;
    private JFrame frame;

    private String ticketDataOutput;

    public ticketDataBaseSearch() {



        frame = new JFrame("Search");
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        search = new JButton("Search");
        search.setBounds(50, 50, 100, 30);
        search.addActionListener(this);
        frame.add(search);

        searchLabel = new JLabel("Enter Ticket ID");
        searchLabel.setBounds(50, 100, 100, 30);
        frame.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(150, 100, 100, 30);
        frame.add(searchField);

        result = new JTextArea();
        result.setBounds(50, 150, 400, 300);
        frame.add(result);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            dbManager = new DBManager();
            try {
                stmt = dbManager.getConnection().createStatement();
                String nameID = ticketDataBaseSearch.searchField.getText();
                String sql = "SELECT * FROM TicketData WHERE FirstName = '" + nameID + "'";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println(sql);
                //clear the text area
                ticketDataBaseSearch.result.setText("");
                if (rs.next()) {
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String arrivalDestination = rs.getString("ArrivalDestination");
                    String departure = rs.getString("Departure");
                    String flightNumber = rs.getString("FlightNumber");
                    String flightTime = rs.getString("FlightTime");
                    String boardingTime = rs.getString("BoardingTime");
                    String gate = rs.getString("Gate");
                    String seatNumber = rs.getString("SeatNumber");

                    ticketDataOutput = ("Name: " + firstName +" "+ lastName + "\n" + "Arrival Destination: " + arrivalDestination + "\n" + "Departure: " + departure + "\n" + "Flight Time: " + flightTime + "hours" + "\n" + "Flight Number: " + flightNumber + "\n" + "Boarding Time: " + boardingTime + "\n" + "Gate: " + gate + "\n" + "Seat Number: " + seatNumber);
                    result.append(ticketDataOutput);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        new ticketDataBaseSearch();
    }


}
