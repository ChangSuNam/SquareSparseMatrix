
/* Based on Cay Horstmann, "Object-Oriented Design and Patterns" */
/**
 * This class is a helper class for SquareSparseMatrix. It holds information for
 * row, column, and value.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2 2.1
 *
 */
public class Entry {
	/**
	 * Constructor for Entry and its row, column and value
	 * 
	 * @param r the row
	 * @param c the column
	 * @param v the value
	 */
	public Entry(int r, int c, double v) {
		row = r;
		col = c;
		val = v;
	}

	/**
	 * This method returns the information for row
	 * 
	 * @return row the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * This method returns the information for column
	 * 
	 * @return col the column
	 */
	public int getColumn() {
		return col;
	}

	/**
	 * This method sets a new value for row and column pair
	 * 
	 * @param v the new value to be set
	 */
	public void setValue(double v) {
		val = v;
	}

	/**
	 * This method returns the information for value
	 * 
	 * @return val the value
	 */
	public double getValue() {
		return val;
	}

	/**
	 * This method returns the stored information in string
	 */
	public String toString() {
		return "(" + row + "," + col + "," + val + ")";
	}

	/**
	 * row the row col the column val the value for row and column pair
	 */
	private int row;
	private int col;
	private double val;
}
