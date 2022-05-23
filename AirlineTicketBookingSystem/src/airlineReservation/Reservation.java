package airlineReservation;

public class Reservation {
    private SeatLayout seatLayout;

    public Reservation(SeatLayout seatLayout) {
        this.seatLayout = seatLayout;
    }
    /**
     * If the seat is not reserved, reserve it
     *
     * @param row The row of the seat to be reserved.
     * @param column The column of the seat to be reserved.
     * @return A boolean value.
     */

    public boolean reserveSeat(Row row, Column column) {
        if ((this.seatLayout.getColumn(column).length > 0) && (this.seatLayout.getRow(row).length > 0)) {
            if (!this.seatLayout.getSeat(new Position(row, column)).getReserved()) {
                this.seatLayout.getSeat(new Position(row, column)).setReserved(true);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String total = "";
        total += "-----This is the seat layout:----- \n";
        total += "----------------------------------\n";
        total += this.seatLayout.toString().trim() + "\n";
        total += "----------------------------------\n";

        return total;
    }
}
