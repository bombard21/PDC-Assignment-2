package AirlineTicketBookingCode;

import java.io.IOException;

public interface TripPlanner {
    int planeFlightTime(String arrivalCity);
    String createDepartureTime();
    String setArrivalTime();
    String timeOfDay(int time);
    String createFlightNumber();
    String createGateNumber();
    void displayTrip() throws IOException;

}
