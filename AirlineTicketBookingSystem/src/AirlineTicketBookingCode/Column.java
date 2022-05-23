package AirlineTicketBookingCode;

public class Column {
    private char letter;

    public Column(char column) {
        this.letter = column;
    }

    public char getLetter() {
        return this.letter;
    }

    /**
     * If the letter of the column is equal to the letter of the other column, then return true.
     *
     * @param column The column to compare to.
     * @return A boolean value.
     */
    public boolean equals(Column column) {
        return this.letter == column.getLetter();
    }

    public String toString() {
        return String.valueOf(this.letter);
    }

}
