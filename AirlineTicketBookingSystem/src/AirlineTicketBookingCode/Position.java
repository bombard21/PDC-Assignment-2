package AirlineTicketBookingCode;

public class Position {

    private Row row;
    private Column column;

    public Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    /**
     * If the column and row of the current position are equal to the column and row of the position passed in, then the
     * two positions are equal
     *
     * @param position The position to compare to.
     * @return The boolean value of whether the two positions are equal.
     */
    @Override
    public boolean equals(Object position) {
        if (position instanceof Position) {
            Position otherPosition = (Position) position;
            return this.row.getRowNumber() == otherPosition.getRow().getRowNumber() && this.column.getLetter() == (otherPosition.getColumn().getLetter());
        }
        return false;
    }

    /**
     * The function returns a string that is the row number and the column letter of the cell
     *
     * @return The row number and the column letter.
     */
    @Override
    public String toString() {
        return this.row.getRowNumber() + " " + this.column.getLetter();
    }

    public Column getColumn() {
        return this.column;
    }

    public Row getRow() {
        return this.row;
    }


}
