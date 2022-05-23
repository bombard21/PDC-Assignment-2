package AirlineTicketBookingCode;


public class Seat {
    private final SeatType seatType;

    private final Row row;
    private final Column column;
    private boolean isReserved;

    public Seat(SeatType seatType, Position position, Row row, Column column) {
        this.seatType = seatType;
        this.row = row;
        this.column = column;
        this.isReserved = false;
    }


    /**
     * This function returns a string that represents the seat's row number, column letter, and whether or not it is
     * reserved
     *
     * @return A string representation of the seat.
     */
    @Override
    public String toString() {
        char reserved;
        if (this.isReserved) {
            reserved = 'X';
        } else {
            reserved = ' ';
        }
        return " " + this.row.getRowNumber() + this.column.getLetter() + " [" + reserved + "]";
    }

    public boolean getReserved() {
        return this.isReserved;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }


}
