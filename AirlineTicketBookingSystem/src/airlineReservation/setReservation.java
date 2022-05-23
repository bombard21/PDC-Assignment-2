package airlineReservation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class setReservation{
    private static Reservation reservePlane;
    public static void setReservation() {
        reservePlane = new Reservation(new SeatLayout(9, 5));
    }

    static public void ReservePlane() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row number: (1-9)");
        int row = scanner.nextInt();
        System.out.println("Enter the column number: (A-E)");
        char column = scanner.next().charAt(0);
        column = Character.toUpperCase(column);

        //if not within the range of the plane's columns and rows then it will not be a valid input
        if (!(row >= 1 && row <= 9 && (column >= 'A' && column <= 'E'))) {
            System.out.println("Please enter a valid seat position");
            ReservePlane();
        } else {

            boolean isReserved = reservePlane.reserveSeat(new Row(row), new Column(column));
            if (!isReserved) {
                System.out.println("Seat is already reserved");
                ReservePlane();
            }
            System.out.println(reservePlane);
        }

        try {
            FileWriter fileWriter = new FileWriter("Resource/Ticket.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("Your seat is: "+ row + column);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
