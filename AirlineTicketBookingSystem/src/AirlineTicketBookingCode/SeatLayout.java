package AirlineTicketBookingCode;

public class SeatLayout {
    private final char LETTER = 'A';
    private final int numberOfRows;
    private final int numberOfColumns;
    private Seat[][] seats;

    public SeatLayout(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.initializeSeats();
    }

    /**
     * If the row number is valid, return the row
     *
     * @param row The row you want to get the seats from.
     * @return An array of seats.
     */
    public Seat[] getRow(Row row) {
        if (translate(row) < this.numberOfRows && translate(row) >= 0) {
            return this.seats[translate(row)];
        } else {
            return new Seat[]{};
        }
    }


    /**
     * > This function returns an array of seats in a given column
     *
     * @param column The column you want to get the seats from.
     * @return An array of seats.
     */
    public Seat[] getColumn(Column column) {
        int columnNumber = translate(column);
        Seat[] columnSeats = new Seat[this.numberOfRows];
        for (int i = 0; i < this.numberOfRows; i++) {
            columnSeats[i] = this.seats[i][columnNumber];
        }
        return columnSeats;
    }

    /**
     * > This function initializes the seats of the theater by creating a 2D array of seats, and then populating the array
     * with seats of the appropriate type and position
     */
    private void initializeSeats() {
        this.seats = new Seat[this.numberOfRows][this.numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Position position = translate(i, j);
                Seat seat = new Seat(seatType(j), position, position.getRow(), position.getColumn());
                this.seats[i][j] = seat;
            }
        }
    }

    /**
     * It takes a row and column index and returns a Position object
     *
     * @param i the row index
     * @param j the column index
     * @return A Position object.
     */
    private Position translate(int i, int j) {
        return new Position(new Row(i + 1), new Column((char) (j + LETTER)));
    }

    private int translate(Row row) {
        return row.getRowNumber();
    }

    private int translate(Column column) {
        return column.getLetter() - LETTER;
    }

    /**
     * If j is 0 or 5, return SeatType.WINDOW, else if j is 3, return SeatType.MIDDLE, else return SeatType.AISLE.
     *
     * @param j the column number of the seat
     * @return The seat type is being returned.
     */
    private SeatType seatType(int j) {
        if (j == 0 || j == 5) {
            return SeatType.WINDOW;
        } else if (j == 3) {
            return SeatType.MIDDLE;
        } else {
            return SeatType.AISLE;
        }
    }

    /**
     * If the column letter is A, C, or E, return FIRST_CLASS; if the column letter is B, D, or F, return BUSINESS_CLASS;
     * otherwise, return ECONOMY_CLASS.
     *
     * @param columnLetter The column letter of the seat.
     * @return The seat class type of the seat.
     */
//    public SeatClassType SeatClassType(char columnLetter) {
//        if (columnLetter == 'A' || columnLetter == 'B' || columnLetter == 'C') {
//            return SeatClassType.FIRST_CLASS;
//        } else if (columnLetter == 'D' || columnLetter == 'E' || columnLetter == 'F') {
//            return SeatClassType.BUSINESS_CLASS;
//        } else {
//            return SeatClassType.ECONOMY_CLASS;
//        }
//    }



    /**
     * If the position is valid, return the seat at that position.
     *
     * @param p The position of the seat you want to get.
     * @return A Seat object.
     */
    public Seat getSeat(Position p) {
        if (p.getRow().getRowNumber() <= this.numberOfRows && p.getColumn().getLetter() <= this.numberOfColumns) {
            return this.seats[p.getRow().getRowNumber() - 1][p.getColumn().getLetter() - LETTER];
        } else {
            return null;
        }
    }

    /**
     * The function takes a 2D array of seats and returns a string representation of the seats
     *
     * @return A string representation of the seating chart.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                sb.append(seats[i][j].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //determine the seat type depending on the column letter

}
