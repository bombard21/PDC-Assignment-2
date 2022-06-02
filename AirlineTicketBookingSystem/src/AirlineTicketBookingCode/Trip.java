package AirlineTicketBookingCode;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Trip implements TripPlanner{
    public static TripPlanner trip = new Trip();
    private final Random rand = new Random();
//    public static User user;
    private String arrivalCity;
    private int departureTime;
    private int arrivalTime;
    private String flightNumber;
    private String flightTime;
    private String gateNumber;

    private String departureDate;


    public Trip() {
//        user =
//        this.user = user;
    }

    //give flight time from auckland to different locations
//    public int planeFlightTime(String arrivalCity) {
//        /** Hamilton, QueensTown, Christchurch, Rotorua,Wellington, Dunedin, Kaitai, Tauranga, Stewart Island, Palmeston North, Whangerai*/
//        int flightTime = 0;
//
//        if (user.getArrivalCity().equalsIgnoreCase("Hamilton")) {
//            flightTime= 2;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Wellington") || user.getArrivalCity().equalsIgnoreCase("Dunedin") || user.getArrivalCity().equalsIgnoreCase("Kaitaia")) {
//            flightTime= 3;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Queenstown")) {
//            flightTime= 5;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Christchurch")) {
//            flightTime= 5;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Rotorua")) {
//            flightTime= 1;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Tauranga")) {
//            flightTime= 2;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Stewart Island")) {
//            flightTime= 6;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Palmerston North")) {
//            flightTime= 3;
//        } else if (user.getArrivalCity().equalsIgnoreCase("Whangarei")) {
//            flightTime= 1;
//        }
//        return flightTime;
//    }


    //set the arrival city to what the user inputs in the User Class

    @Override
    public int planeFlightTime(String arrivalCity) {
        return 0;
    }

    //generates a random time stamp in a 13-hour format for departure time


    public String createDepartureTime() {
        this.departureTime = (rand.nextInt(12));
        return this.departureTime + timeOfDay(departureTime);
    }

    public String setArrivalTime() {
        // returns the arrival time
        //adds the flight time to the departure time
        this.arrivalTime = this.departureTime + planeFlightTime(arrivalCity);
        return this.arrivalTime + timeOfDay(arrivalTime);
    }


    /**
     * If the time is less than 12, return AM, if the time is greater than 12, return PM, otherwise return the timeOfDay
     * function.
     *
     * @param time the time of day in 24 hour format
     * @return The time of day.
     */
    public String timeOfDay(int time) {
//        if (time < 12) {
//            return "AM";
//        } else if (time > 12) {
//            return "PM";
//        } else {
//            return "";
//        }
        return "";
    }


    /**
     * This function creates a random flight number by generating three random numbers and adding them together
     *
     * @return The flight number is being returned.
     */
    public String createFlightNumber() {
        int flightNumber = rand.nextInt(9) + 1;
        int flightNumber2 = rand.nextInt(9) + 1;
        int flightNumber3 = rand.nextInt(9) + 1;

        return this.flightNumber = flightNumber + " " + flightNumber2 + " " + flightNumber3;
    }

    @Override
    public String createGateNumber() {
        return this.gateNumber = "Gate " + rand.nextInt(9) + 1;
    }



    /**
     * This function is used to display the flight details of the user's trip
     */
    public void displayTrip() throws IOException {
//        FileWriter fileWriter = new FileWriter("./Resource/Flightdata.txt",true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        ArrayList<String> flightData = new ArrayList<>();
//
//        flightData.add("===========================================================");
//        flightData.add("Departure City: Auckland");
//        flightData.add("Arrival City: " + user.getArrivalCity());
//        flightData.add("Departure Time: " + createDepartureTime());
//        flightData.add("Arrival Time: " + setArrivalTime());
//        flightData.add("Flight Number: " + createFlightNumber());
//        flightData.add("Flight Time: " + planeFlightTime(user.getArrivalCity()) + " hours");
//        flightData.add("===========================================================");
//        try {
//            for (String FlightData : flightData) {
//                bufferedWriter.append(FlightData + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        bufferedWriter.close();
    }
    
    

}


