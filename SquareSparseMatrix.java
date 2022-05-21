
/* Based on Cay Horstmann, "Object-Oriented Design and Patterns" */

/**
 *This class creates matrix that are square, that is , the length of row and column equals. It contains methods that access or modify the matrix.
 * 
 *@author ChangSu Nam
 *@UNI cn2521
 *@since Assignment 2, 2.1 
 */
import java.util.*;

/**
 * This class creates matrix that are square, that is , the length of row and
 * column equals. It uses a helper class called Entry to stroe the value of row
 * and column in List. This class contains methods that access or modify the
 * matrix, such as get and set. There are multiple constructors that creates
 * matrix with different inputs, such as value of row and column, and 2D array.
 * In addition, the constructor that takes single input of integer creates an
 * identity matrix with row and column of the given input. The times and plus
 * method carries out matrix multiplication and matrix addition.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2, 2.1
 */
public class SquareSparseMatrix {
	/**
	 * 
	 * This is a constructor that creates square matrix from the given inputs as its
	 * row and column. It throws exception when the input for row and column is less
	 * than or equal to zero, because matrix has to have row and column of length 1
	 * at minimum. It throws exception when the input for row and column does not
	 * equal. The matrix should be square, thus row and column must equal.
	 * 
	 * @param rows the row of the Matrix to be created
	 * @param cols the column of the Matrix to be created
	 * @throws HiddenStacktraceException the exception without trace for users
	 * 
	 */

	public SquareSparseMatrix(int rows, int cols) throws HiddenStacktraceException {

		if (rows <= 0 || cols <= 0) {

			throw new HiddenStacktraceException("Can not construct this matrix with size less than or equal to zero",
					true);
		}
		if (rows != cols) {
			throw new HiddenStacktraceException("The length of row and col does not equal. The Matrix must be square!",
					true);
		}
		this.rows = rows;
		this.cols = cols;
		entries = new ArrayList<Entry>();
	}

	/**
	 * This is a constructor that creates square matrix with an input of 2
	 * dimensional array. It throws an exception when the array and nested array
	 * does not have the same length, so that the created array is always square.
	 * 
	 * @param inputDoubleArray the double array
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SquareSparseMatrix(double[][] inputDoubleArray) throws HiddenStacktraceException {

		for (int i = 0; i < inputDoubleArray.length; i++) {

			if (inputDoubleArray.length != inputDoubleArray[i].length) {
				throw new HiddenStacktraceException(
						"To make a square matrix, the length of row and column of the 2 D array must equal.", true);
			}

		}

		this.rows = inputDoubleArray.length;
		this.cols = inputDoubleArray[0].length;
		entries = new ArrayList<Entry>();

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.set(i, j, inputDoubleArray[i][j]);
			}
		}

	}

	/**
	 * This constructor creates an identity matrix with the size of given input.
	 * Identity matrix are matrix with 1 in the diagonal pair of rows and column,
	 * that is , pair with equal row and column, and 0s in the rest of the pairs.
	 * 
	 * @param sizeOfMatrix the size of identity matrix to be created
	 */

	public SquareSparseMatrix(int sizeOfMatrix) {

		this.rows = sizeOfMatrix;
		this.cols = sizeOfMatrix;
		entries = new ArrayList<Entry>();

		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if (i == j) {
					this.set(i, j, 1.0);
				} else {
					this.set(i, j, 0.0);
				}
			}
		}

	}

	/**
	 * This method returns a new matrix with its value added to the input matrix. It
	 * throws exception when the input matrix is null, if the sizes of two matrices
	 * to be added do not equal, or if the matrices are not square.
	 * 
	 * @param inputMatrix the matrix to get values from
	 * @return resultMatrix a new matrix with values added to
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SquareSparseMatrix plus(SquareSparseMatrix inputMatrix) throws HiddenStacktraceException {
		if (inputMatrix == null) {
			throw new HiddenStacktraceException("Matrix is null", true);
		}

		if (rows != inputMatrix.rows || cols != inputMatrix.cols) {
			throw new HiddenStacktraceException("Size of two matrices do not equal, cannot add!", true);
		}
		if (rows != cols || inputMatrix.rows != inputMatrix.cols) {
			throw new HiddenStacktraceException("Matrix is not square", true);
		}
		SquareSparseMatrix resultMatrix = new SquareSparseMatrix(rows, cols);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				resultMatrix.set(i, j, get(i, j) + inputMatrix.get(i, j));
		return resultMatrix;
	}

	/**
	 * returns a new matrix with its value multiplied to the input matrix. It throws
	 * exception when the input matrix is null, the sizes of two matrices to be
	 * multiplied do not equal, or if the matrices are not square.
	 * 
	 * @param inputMatrix the matrix to be multiplied with.
	 * @return resultMatrix the new matrix with values multiplied to.
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SquareSparseMatrix times(SquareSparseMatrix inputMatrix) throws HiddenStacktraceException {
		if (inputMatrix == null) {
			throw new HiddenStacktraceException("Matrix is null", true);
		}
		if (rows != inputMatrix.rows || cols != inputMatrix.cols) {
			throw new HiddenStacktraceException("Size of two matrices do not equal, cannot add!", true);
		}
		if (rows != cols || inputMatrix.rows != inputMatrix.cols) {
			throw new HiddenStacktraceException("Matrix is not square", true);
		}
		SquareSparseMatrix resultMatrix = new SquareSparseMatrix(rows, inputMatrix.cols);
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < inputMatrix.cols; j++) {
				double temp = 0;
				for (int k = 0; k < cols; k++)
					temp = temp + get(i, k) * inputMatrix.get(k, j);
				resultMatrix.set(i, j, temp);
			}
		return resultMatrix;
	}

	/**
	 * This method creates a 2D array from the values contained in row and column
	 * pairs of Matrix.
	 * 
	 * @return arrayFromMatrix the 2D array created from Matrix.
	 */
	public double[][] toArray() {
		double[][] arrayFromMatrix = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arrayFromMatrix[i][j] = get(i, j);
			}
		}

		return arrayFromMatrix;
	}

	/**
	 * This method checks if the matrices are equal. Matrices are considered equal
	 * if they have the same number of rows, same number of columns, and same values
	 * at each pair of row and column.
	 * 
	 * @param inputMatrix the matrix to check if it equals with.
	 * @return true if the matrices are equal, false if they are different
	 */
	public boolean equals(SquareSparseMatrix inputMatrix) {
		if (inputMatrix.getRows() != this.getRows() || inputMatrix.getCols() != this.getCols()) {
			return false;
		}

		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				if (this.get(i, j) != inputMatrix.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method checks if the matrix provided as input is an identity matrix.
	 * Identity matrix are matrix with 1 in the diagonal pair of rows and column,
	 * that is , pair with equal row and column, and 0s in the rest of the pairs.
	 * 
	 * @param inputMatrix the matrix to check if it is identity.
	 * @return true when the input is an identity matrix, false when the input is
	 *         not an identity matrix.
	 */
	public static boolean isIdentity(SquareSparseMatrix inputMatrix) {
		for (int i = 0; i < inputMatrix.getRows(); i++) {
			for (int j = 0; j < inputMatrix.getCols(); j++) {
				if (inputMatrix.get(i, j) != 1 && inputMatrix.get(j, i) != 0) {
					return false;
				}
				if (i == j && inputMatrix.get(j, i) != 1) {

					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This method returns the Matrix in String, in a clean form
	 */
	public String toString() {
		String r = "";
		for (int i = 0; i < rows; i++) {
			r += "[";
			for (int j = 0; j < cols; j++) {
				r += String.format("%10.2f ", get(i, j));
			}
			r += "]\n";
		}
		return r;
	}

	/**
	 * This method returns the row of matrix.
	 * 
	 * @return rows the row of matrix
	 */
	public double getRows() {
		return rows;
	}

	/**
	 * This method returns the column of matrix
	 * 
	 * @return cols the column of matrix
	 */
	public double getCols() {
		return cols;
	}

	/**
	 * This method returns the specific value at row and column provided in input.
	 * 
	 * @param r the row to check value
	 * @param c the column to check value
	 * @return the value contained in the entry
	 */
	public double get(int r, int c) {
		for (Entry e : entries) {
			if (e.getRow() == r && e.getColumn() == c)
				return e.getValue();
		}
		return 0.0;
	}

	/**
	 * This method sets a new value at row and column provided in input. If v, the
	 * value to be assigned is 0, the method will remove the value from Entry.
	 * 
	 * @param r the row for new value to be assigned
	 * @param c the column for new value to be assigned
	 * @param v the value to be set at matrix's row and column pair
	 */
	public void set(int r, int c, double v) {
		for (Entry e : entries) {
			if (e.getRow() == r && e.getColumn() == c) {
				if (v == 0)
					entries.remove(e);
				else
					e.setValue(v);
				return;
			}
		}
		entries.add(new Entry(r, c, v));
	}

	/**
	 * entries, the entry of row, column and value for the matrix rows, rows, the
	 * row of matrix cols, the column of matrix
	 */
	private ArrayList<Entry> entries;
	private int rows;
	private int cols;
}