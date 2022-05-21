import java.util.*;

/**
 * This class creates matrix that are symmetric, that is , the length of row and
 * column equals, and the values in the upper triangle mirrors the values in the
 * lower triangle, symmetrically. It stores the values of an upper triangle in
 * an array, compact and efficiently.It contains methods that access or modify
 * the matrix, such as get and set. There are multiple constructors that creates
 * matrix with different inputs, such as value of dimension, and 2D array. In
 * addition, the constructor that takes single input of integer and any string
 * of "identity" creates an identity matrix with row and column of the given
 * input. The times and plus method carries out matrix multiplication and matrix
 * addition. Since this class only represents symmetric matrices, some values
 * are lost in calculation- they are replaced with the values in the upper
 * triangle. This is also true for constructor that takes 2d array as input.
 * This is a limitation of this class.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2, 2.3
 */
public class SymmetricMatrix {

	/**
	 * This constructor takes no input, and creates a default symmetric matrix of
	 * dimension 5. It saves values of matrix in an array of size
	 * counterForElementsInTriangle, which is size of an upper triangle.
	 */
	public SymmetricMatrix() {

		this.dimension = 5;
		counterForElementsInTriangle = dimension*(dimension + 1) / 2;
		entries = new double[counterForElementsInTriangle];
	}

	/**
	 * 
	 * This is a constructor that creates symmetric matrix from the given inputs as
	 * its dimension. It throws exception when the input is less than or equal to
	 * zero, because matrix has to have row and column of length 1 at minimum. It
	 * saves values of matrix in an array of size counterForElementsInTriangle,
	 * which is size of an upper triangle.
	 * 
	 * @param dimension the dimension of matrix to be created
	 * @throws HiddenStacktraceException the exception without trace for users
	 * 
	 */
	public SymmetricMatrix(int dimension) throws HiddenStacktraceException {
		if (dimension <= 0) {
			throw new HiddenStacktraceException("Can not construct this matrix with size less than or equal to zero",
					true);
		}

		this.dimension = dimension;
		counterForElementsInTriangle = dimension*(dimension + 1) / 2;
		entries = new double[counterForElementsInTriangle];
	}

	/**
	 * 
	 * This is a constructor that creates a symmetric identity matrix when String of
	 * "identity" is inserted along with input for dimension. It throws exception
	 * when the input is less than or equal to zero, because matrix has to have row
	 * and column of length 1 at minimum. It saves values of matrix in an array of
	 * size counterForElementsInTriangle, which is size of an upper triangle.
	 * Identity matrix are matrix with 1 in the diagonal pair of rows and column,
	 * that is , pair with equal row and column, and 0s in the rest of the pairs.
	 * 
	 * @param dimension the dimension of matrix to be created
	 * @param id        the input that checks the keyword "identity"
	 * @throws HiddenStacktraceException the exception without trace for users
	 * 
	 */
	public SymmetricMatrix(int dimension, String id) throws HiddenStacktraceException {

		if (dimension <= 0) {
			throw new HiddenStacktraceException("Can not construct this matrix with size less than or equal to zero",
					true);
		}

		this.dimension = dimension;
		counterForElementsInTriangle = dimension*(dimension + 1) / 2;
		entries = new double[counterForElementsInTriangle];

		if (id.equals("identity")) {
			for (int i = 0; i < dimension; i++) {
				for (int j = 0; j < dimension; j++) {
					if (i == j) {
						this.set(i, j, 1.0);
					} else {
						this.set(i, j, 0.0);
					}
				}
			}
		}

	}

	/**
	 * This is a constructor that creates square matrix with an input of 2
	 * dimensional array. It throws an exception when the array and nested array
	 * does not have the same length, so that the created array is always square. A
	 * limitation to this method is that since this class creates symmetric matrices
	 * from upper triangle, values that should be assigned in the lower triangle is
	 * lost due to the nature of the class.
	 * 
	 * @param inputDoubleArray the double array
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SymmetricMatrix(double[][] inputDoubleArray) throws HiddenStacktraceException {
		for (int i = 0; i < inputDoubleArray.length; i++) {

			if (inputDoubleArray.length != inputDoubleArray[i].length) {
				throw new HiddenStacktraceException(
						"To make a square matrix, the length of row and column of the 2 D array must equal.", true);
			}
		}

		this.dimension = inputDoubleArray.length;
		counterForElementsInTriangle = dimension*(dimension + 1) / 2;
		entries = new double[counterForElementsInTriangle];
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				this.set(i, j, inputDoubleArray[i][j]);
			}
		}

	}

	/**
	 * This method returns a new matrix with its value added to the input matrix. It
	 * throws exception when the input Matrix is null, or the dimension of two
	 * matrices to be added are not equal.
	 * 
	 * @param inputMatrix the matrix to get values from
	 * @return resultMatrix a new matrix with values added to
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SymmetricMatrix plus(SymmetricMatrix inputMatrix) throws HiddenStacktraceException {
		if (inputMatrix == null) {
			throw new HiddenStacktraceException("Matrix is null", true);
		}

		if (dimension != inputMatrix.dimension) {
			throw new HiddenStacktraceException("Size of two matrices do not equal, cannot add!", true);
		}

		SymmetricMatrix resultMatrix = new SymmetricMatrix(dimension);
		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < dimension; j++)
				resultMatrix.set(i, j, get(i, j) + inputMatrix.get(i, j));
		return resultMatrix;
	}

	/**
	 * This method returns a new matrix with its value multiplied to the input
	 * matrix. It throws exception when the input matrix is null, or the dimension
	 * of two matrices to be added are not equal. A limitation to this method is
	 * that since this class creates symmetric matrices from upper triangle,
	 * calculated values in the lower triangle is lost due to the nature of the
	 * class.
	 * 
	 * @param inputMatrix the matrix to be multiplied with.
	 * @return resultMatrix the new matrix with values multiplied to.
	 * @throws HiddenStacktraceException the exception without trace for users
	 */
	public SymmetricMatrix times(SymmetricMatrix inputMatrix) throws HiddenStacktraceException {
		if (inputMatrix == null) {
			throw new HiddenStacktraceException("Matrix is null", true);
		}

		if (dimension != inputMatrix.dimension) {
			throw new HiddenStacktraceException("Size of two matrices do not equal, cannot add!", true);
		}
		SymmetricMatrix resultMatrix = new SymmetricMatrix(dimension);
		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < inputMatrix.dimension; j++) {
				double temp = 0;
				for (int k = 0; k < dimension; k++)
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
		double[][] arrayFromMatrix = new double[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
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
	public boolean equals(SymmetricMatrix inputMatrix) {
		if (inputMatrix.getDimension() != this.getDimension()) {
			return false;
		}

		for (int i = 0; i < this.getDimension(); i++) {
			for (int j = 0; j < this.getDimension(); j++) {
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
	 * @param inputMatrix the matrix to be checked if it is identity.
	 * @return true when the input is an identity matrix, false when the input is
	 *         not an identity matrix.
	 */
	public static boolean isIdentity(SymmetricMatrix inputMatrix) {
		for (int i = 0; i < inputMatrix.getDimension(); i++) {
			for (int j = 0; j < inputMatrix.getDimension(); j++) {
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
		int dimensionCount = dimension + 1;
		for (int i = 0; i < dimension; i++) {
			r += "[";
			for (int j = 0; j < dimension; j++) {
				// System.out.println("i: " + i + " j: " + j);

				r += String.format("%10.2f ", get(i, j));
				// String.format("%10.2f ", get(i, j))
				if (dimensionCount % dimension == 0) {
					r += "]\n";
				}
				dimensionCount++;
			}
		}
		return r;
	}

	/**
	 * This method returns the dimension of the matrix.
	 * 
	 * @return the dimension of matrix
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * This method calculates the index where the value at (row, column) of the
	 * matrix should be stored in an 1 D arra. F
	 * 
	 * @param row the row of the matrix
	 * @param col the column of the matrix
	 * @return the calculated index
	 */
	public int getIndex(int row, int col) {
		return (dimension*(row) - (row - 1)*(row)/2) + (col - row);
	}

	/**
	 * This method returns the total number of elements in the upper triangle of the
	 * matrix.
	 * 
	 * @return the numbe of elements in the upper triangle.
	 */
	public int getNumberOfElements() {
		return entries.length;
	}

	/**
	 * This method sets a new value at row and column provided in input, using
	 * getIndex() method to set values in 1D array.
	 * 
	 * @param r     the row for new value to be assigned
	 * @param c     the column for new value to be assigned
	 * @param value the value to be set at matrix's row and column pair.
	 */
	public void set(int r, int c, double value) {
		if (r <= c) {
			int index = getIndex(r, c);
			entries[index] = value;
		}
		if (c < r) {
			int index = getIndex(c, r);
		}
	}

	/**
	 * This method returns the specific value at row and column provided in input.
	 * It uses getIndex method to access 1D array.
	 * 
	 * @param r the row to check value
	 * @param c the column to check value
	 * @return the value contained in the entry
	 */
	public double get(int r, int c) {
		if (r <= c) { // make an upper triangle
			int index = getIndex(r, c);
			return entries[index];
		}
		if (c < r) {
			int index = getIndex(c, r);
			return entries[index];
		}

		return 0;
	}

	/**
	 * dimension the length of row and column. For instance, dimension of 5 means
	 * there are 5 rows and 5 column
	 * 
	 * entries the 1D array that holds double value of what is stored in Matrix.
	 * 
	 * counterForElementsInTriangle the number of elements that will go in either
	 * upper or lower triangle of matrix. Since they are symmetric, only need about
	 * half of the total element.
	 */
	private int dimension;
	private double[] entries;
	private int counterForElementsInTriangle;
}