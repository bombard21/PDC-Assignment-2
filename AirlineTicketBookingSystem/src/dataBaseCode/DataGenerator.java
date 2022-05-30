package dataBaseCode;

public class DataGenerator {
    public AirlineTicketBookingCode.Trip trip;

    public DataGenerator(AirlineTicketBookingCode.Trip trip) {
        this.trip = trip;
    }

    public void generate() {
        trip.createDepartureTime();
        trip.setArrivalTime();
        trip.createFlightNumber();

    }
}
