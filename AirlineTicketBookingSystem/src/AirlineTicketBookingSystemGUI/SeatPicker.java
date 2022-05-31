package AirlineTicketBookingSystemGUI;

import AirlineTicketBookingCode.Column;
import AirlineTicketBookingCode.Row;
import AirlineTicketBookingCode.SeatLayout;
import AirlineTicketBookingCode.setReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static AirlineTicketBookingCode.setReservation.ReservePlane;


public class SeatPicker extends JFrame implements ActionListener {

    public AirlineTicketBookingCode.Reservation reservation;
    //create a double array of JButtons
    private JButton[][] seats;

    //create a JPanel to hold the seats
    private JPanel seatsPanel;
    //create a label for a prompt
    private JLabel prompt;
    private JLabel prompt2;
    //create a text field for the selected seat
    private JTextField seat;
    private JButton confirm;



    public SeatPicker() {
        //create a new reservation
        reservation = new AirlineTicketBookingCode.Reservation(new SeatLayout(10,5));
        //create a JPanel to ask the user to click on a seat
        JPanel promptPanel = new JPanel();
        promptPanel.setLayout(new FlowLayout());
        prompt = new JLabel("Click on a seat to reserve it.");
        promptPanel.add(prompt);
        //create a JPanel to hold the seats
        seatsPanel = new JPanel();
        seatsPanel.setLayout(new GridLayout(10, 5));
        //create a double array of JButtons
        seats = new JButton[10][5];
        //create a JPanel to hold the seats
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = new JButton("" + (i * 5 + j + 1));
                seats[i][j].addActionListener(this);
                seatsPanel.add(seats[i][j]);
            }
        }
        //create a JPanel to hold the text field and label
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        prompt2 = new JLabel("Selected seat: ");
        seat = new JTextField(10);
        seat.setEditable(false);
        textPanel.add(prompt2);
        textPanel.add(seat);
        //add the button next to the text field
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        textPanel.add(confirm);
        //create a JPanel to hold the two JPanels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(promptPanel, BorderLayout.NORTH);
        mainPanel.add(seatsPanel, BorderLayout.CENTER);
        mainPanel.add(textPanel, BorderLayout.SOUTH);
        //create a JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Seating Plan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 300));
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    //paint the seats

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 5; j++) {
                if(e.getSource() == seats[i][j]) {
                    //disable the button
                    seats[i][j].setEnabled(false);
                    //set the text of the text field
                    seat.setText("" + (i * 5 + j + 1));

                    boolean isReserved = reservation.reserveSeat(new Row(i), new Column((char) j));
                    if (!isReserved) {
                        ReservePlane();
                    }
                    System.out.println(reservation.reserveSeat(new Row(i), new Column((char) j)));
                }
            }
        }
        
        if(e.getSource() == confirm){
            User user = new User();
            user.setVisible(true);
        }
        
        
    }

    public static void main(String[] args) {
        new SeatPicker();

    }

}

