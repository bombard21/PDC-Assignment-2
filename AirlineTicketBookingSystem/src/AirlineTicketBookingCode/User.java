package AirlineTicketBookingCode;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements UserQuestions{
    private String firstName;
    private String lastName;
    private String DOB;
    private String destination;
    private String planeName;
    private String methodOfTransport;

    //constructor
    public User() {
    }


    //method to ask the user for input using scanner
    public void askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        this.firstName = scanner.nextLine();
        //check for valid input and then ask for the next input
        while (!this.firstName.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid first name: ");
            this.firstName = scanner.nextLine();
        }

        System.out.println("Please enter your last name: ");
        this.lastName = scanner.nextLine();
        //check for valid input and then ask for the next input
        while (!this.lastName.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid last name: ");
            this.lastName = scanner.nextLine();
        }

        System.out.println("Please enter your date of birth: ");
        this.DOB = scanner.nextLine();
        //check for valid input and then ask for the next input
        while (!this.DOB.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            System.out.println("Please enter a valid date of birth: ");
            this.DOB = scanner.nextLine();
        }
    }

    public void validateDestination() throws IOException {
        FileReader fileReader = new FileReader("Resource/Location.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(System.in);
        String word;

        System.out.println("Here are the destinations: ");
        System.out.println("===========Destinations=========");

        while ((word = bufferedReader.readLine()) != null) {
            System.out.println(word);
        }
        System.out.println("===============================");

        System.out.println("Please enter your destination: ");
        this.destination = scanner.nextLine();
        //check that this.destination is found in the file
        Scanner fileScanner = new Scanner(new File("Resource/Location.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.contains(this.destination)) {
                break;
            }else if(!fileScanner.hasNextLine()){
                System.out.println("Please enter a valid destination: ");
                this.destination = scanner.nextLine();
            }
        }
        // This is a while loop that reads the file line by line and then closes the file.

    }

    // TODO: 18/05/2022 make sure that the user can choose a number for their plane
    public void validAirplaneType() throws IOException {
        FileReader fileReader = new FileReader("Resource/Planes.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(System.in);
        String word;
        System.out.println("Here are the planes: ");
        System.out.println("===========Planes=========");
        while ((word = bufferedReader2.readLine()) != null) {
            System.out.println(word);
        }
        System.out.println("===============================");
        System.out.println("Please enter your plane: ");
        this.planeName = scanner.nextLine();

        //check that this.planeName is found in the file
        Scanner fileScanner2 = new Scanner(new File("Resource/Planes.txt"));
        while (fileScanner2.hasNextLine()) {
            String line = fileScanner2.nextLine();
            if (line.contains(this.planeName)) {
                break;
            }else if(!fileScanner2.hasNextLine()){
                System.out.println("Please enter a valid plane: ");
                this.planeName = scanner.nextLine();
            }
        }
    }

    public void validMethodOfTransport() throws IOException {
        FileReader fileReader = new FileReader("Resource/MethodOfTransport.txt");
        BufferedReader bufferedReader3 = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(System.in);
        String word;


        System.out.println("Here are the methods of transport: ");
        System.out.println("===========Methods of Transport=========");
        while ((word = bufferedReader3.readLine()) != null) {
            System.out.println(word);
        }
        System.out.println("===============================");
        System.out.println("Please enter your method of transport to the Gate: ");
        this.methodOfTransport = scanner.nextLine();


        //check that this.methodOfTransport is found in the file
        Scanner fileScanner3 = new Scanner(new File("Resource/MethodOfTransport.txt"));
        while (fileScanner3.hasNextLine()) {
            String line = fileScanner3.nextLine();
            if (line.contains(this.methodOfTransport)) {
                break;
            }else if(!fileScanner3.hasNextLine()){
                System.out.println("Please enter a valid method of transport: ");
                this.methodOfTransport = scanner.nextLine();
            }
        }
    }


    public void sendToFile() throws IOException {
        //write all the user input to a file called Ticket.txt
        FileWriter fileWriter = new FileWriter("Resource/Ticket.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ArrayList<String> userData = new ArrayList<>();

        //add data to arraylist
        userData.add("==============================" + "\n");
        userData.add("First name: " + this.firstName + "\n");
        userData.add("Last name: " + this.lastName + "\n");
        userData.add("DOB: " + this.DOB + "\n");
        userData.add("Plane Choice: " + this.planeName + "\n");
        userData.add("Chosen Destination: " + this.destination + "\n");
        userData.add("==============================");

        try {
            //for loop to print the arraylist
            for (String UserData : userData) {
                bufferedWriter.append(UserData);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getArrivalCity() {
        return this.destination;
    }

    public void fileReader() throws IOException {
        FileReader fileReader = new FileReader("Resource/Ticket.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        boolean EOF = false;
        String line;
        try {
            while (!EOF) {
                line = bufferedReader.readLine();
                if (line == null) {
                    EOF = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader.close();
    }
}
