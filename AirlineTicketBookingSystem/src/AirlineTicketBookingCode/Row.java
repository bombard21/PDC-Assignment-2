package AirlineTicketBookingCode;

public class Row {
    private int rowNumber;

    public Row(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    /**
     * If the object passed in is a Row object and has the same row number as this object, then return true. Otherwise,
     * return false
     *
     * @param other The object to compare this Row to.
     * @return The hashcode of the row number.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Row) {
            Row otherRow = (Row) other;
            return this.rowNumber == otherRow.rowNumber;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rowNumber);
    }

    public int getRowNumber() {
        return this.rowNumber;
    }
}
