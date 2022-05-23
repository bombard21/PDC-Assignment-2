package airlineReservation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login extends AbstractLogin {
    HashMap<String, String> userMap = new HashMap<>();

    public Login(User user) {
        super(user);
    }

    public void userOptions() throws IOException {
        //an option to choose to register or login
        Scanner input = new Scanner(System.in);
        System.out.println("1. Register\n2. Login\n3. Exit");
        //check for valid input and then as for the next input
        int choice = input.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Please enter a valid option");
            choice = input.nextInt();
        }
        if (choice == 1) {
            register();
        } else if (choice == 2) {
            login();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void login() throws IOException {
        //ask the user for username and password
        //check if the username and password is the same as the one stored in the hashmap
        //if this is correct then call method askUser()
        //if not then call method login()
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        if (checkLogin(username, password)) {
            user.validateDestination();
            user.validAirplaneType();
            user.validMethodOfTransport();
            int amount;
            System.out.println("How many tickets do you want to buy?");
            amount = input.nextInt();
            while(amount >= 10){
                System.out.println("Please enter a number less than 10");
                amount = input.nextInt();
            }
            //check for valid input and then as for the next input

            for (int i = 0; i < amount; i++) {
                user.askUser();
                setReservation.ReservePlane();
                user.sendToFile();
            }
        } else {
            login();
        }
    }


    //TODO: check if the username and password exists in the hashmap
    @Override
    public void register() throws IOException {
        //ask the user for username and password
        //store the user input into the 2d array
        //store the username and password into the hashmap

        //check if the username and password is already in the hashmap
        //if this is true call the method login()
        //if not then call the method userOptions()


        Scanner input = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        userMap.put(username, password);

        FileWriter fileWriter = new FileWriter("./Resource/LoginData.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            for(Map.Entry<String, String> entry : userMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }


        //call the method login()
        System.out.println("1. Login\n2. Exit");
        int choice = input.nextInt();
        if (choice == 1) {
            login();
        } else {
            System.exit(0);
        }
    }

    @Override
    public boolean checkLogin(String username, String password) {
        //check if the username and password is correct
        //if correct, return true
        //if not, return false


        String userName = null;
        String passWord = null;
        Map<String, String> Data = new HashMap<>();
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader("./Resource/LoginData.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(":");
                userName = strings[0].trim();
                passWord = strings[1].trim();

                if(!userName.equals("") && !passWord.equals("")) {
                    Data.put(userName, passWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Data.containsKey(username) && Data.get(username).equals(password);
    }
}




