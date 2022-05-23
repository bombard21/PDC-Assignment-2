package airlineReservation;

import java.io.IOException;
import java.util.Scanner;


public class ReserverationApp {
    public static void main(String[] args) throws IOException {

        setReservation.setReservation();
        User user = new User();
        Trip trip = new Trip(user);
        Login login = new Login(user);
        Scanner input = new Scanner(System.in);



        //ASCII welcome message
        System.out.println("+----------------------------------------------------+");
        System.out.println("|                                                    |");
        System.out.println("|                                                    |");
        System.out.println("|           Welcome to Airline Reservation           |");
        System.out.println("|                                                    |");
        System.out.println("|                                                    |");
        System.out.println("+----------------------------------------------------+");


        System.out.println("If you are a new user, Please Register First");
        //call login method userOptions()
        login.userOptions();



        //display the ticket info to a file
        System.out.println("Your ticket has been printed to Ticket.txt");
        System.out.println("all your flight data has been saved to Flightdata.txt");
        trip.displayTrip();



        System.out.println("To exit the program, enter 'exit'");
        String exit = input.nextLine();
        if (exit.equals("exit")) {
            System.exit(0);
        }


        //ASCII goodbye message
        System.out.println("+----------------------------------------------------+");
        System.out.println("|                                                    |");
        System.out.println("|                                                    |");
        System.out.println("|      Thank you for using Airline Reservation       |");
        System.out.println("|                                                    |");
        System.out.println("|                                                    |");
        System.out.println("+----------------------------------------------------+");


    }
}
