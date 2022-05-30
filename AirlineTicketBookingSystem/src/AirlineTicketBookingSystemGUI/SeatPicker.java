package AirlineTicketBookingSystemGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatPicker extends JFrame implements ActionListener {

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
        //create a JPanel to ask the user to click on a seat
        JPanel promptPanel = new JPanel();
        promptPanel.setLayout(new FlowLayout());
        prompt = new JLabel("Click on a seat to reserve it.");
        promptPanel.add(prompt);
        //create a JPanel to hold the seats
        seatsPanel = new JPanel();
        seatsPanel.setLayout(new GridLayout(5, 5));
        //create a double array of JButtons
        seats = new JButton[5][5];
        //create a JPanel to hold the seats
        for (int i = 0; i < 5; i++) {
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
        //when a button is pressed it will update the text field with the new seat number
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (e.getSource() == seats[i][j]) {
                    seat.setText("" + (i * 5 + j + 1));
                }
            }
        }

        //when the user clicks on a seat, the seat will be disabled
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (e.getSource() == seats[i][j]) {
                    seats[i][j].setEnabled(false);
                }
            }
        }
        
        if(e.getSource() == confirm){
            User user = new User();
            user.setVisible(true);
        }
        
        
    }

}

