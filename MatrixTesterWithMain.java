
/* Based on Cay Horstmann, "Object-Oriented Design and Patterns" */
/**
 * This Class contains test cases for SquareSparseMatrix.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2 2.1
 *
 */
import java.util.*;

/**
 * This class contains main method to run the programs to create and modify the
 * matrix.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2 2.1
 *
 */

class MatrixTesterWithMain {
	public static void main(String[] args) throws HiddenStacktraceException {

		// 5 by 5 matrixes adding
		SquareSparseMatrix a = new SquareSparseMatrix(5, 5);
		SquareSparseMatrix b = new SquareSparseMatrix(5, 5);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				a.set(i, j, 10.0 * (double) i);
				b.set(i, j, 100.0);
			}
		System.out.println(a);
		System.out.println("printed a");
		System.out.println("-------------");

		System.out.println(a.get(1, 1));
		System.out.println(a.getCols());
		System.out.println(a.getRows());
		System.out.println("ran get(1,1), getCols() and getRows on a");
		System.out.println("-------------");
		System.out.println(Arrays.deepToString(a.toArray()));
		System.out.println("printed a.toArray()");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");

		System.out.println(b);
		System.out.println("printed b");
		System.out.println("-------------");

		b.set(3, 0, 50);
		System.out.println(b);
		System.out.println("printed b after running b.set(3, 0, 50)");
		System.out.println("-------------");

		System.out.println(a.plus(b));
		System.out.println("printed a.plus(b)");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");
		// 5 by 5 matrix multiplication
		SquareSparseMatrix c = new SquareSparseMatrix(5, 5);
		SquareSparseMatrix d = new SquareSparseMatrix(5, 5);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				c.set(i, j, 1000.0);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				d.set(i, j, 10000.0);
		System.out.println(c);
		System.out.println("printed c");
		System.out.println("-------------");
		System.out.println(d);
		System.out.println("printed d");
		System.out.println("-------------");

		System.out.println(c.times(d));
		System.out.println("printed c.times(d)");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");

		SquareSparseMatrix matrixWithZeroes = new SquareSparseMatrix(5, 5);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				matrixWithZeroes.set(i, j, 0.0);
			}
		System.out.println(matrixWithZeroes);
		System.out.println("printed matrixWithZeroes");
		System.out.println("-------------");

		System.out.println(Arrays.deepToString(matrixWithZeroes.toArray()));
		System.out.println("converted the zero matrix to array");
		System.out.println("-------------");

		System.out.println(d.plus(matrixWithZeroes));
		System.out.println("printed d.plus(matrixWithZeroes)");
		System.out.println("-------------");
		System.out.println(d.times(matrixWithZeroes));
		System.out.println("printed d.times(matrixWithZeroes)");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");

		SquareSparseMatrix matrixWithNoZeroes = new SquareSparseMatrix(5, 5);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrixWithNoZeroes.set(i, j, 10.0);
			}
		}
		System.out.println(matrixWithNoZeroes);
		System.out.println("printed matrixWithNoZeroes");
		System.out.println("-------------");
		System.out.println(d.plus(matrixWithNoZeroes));
		System.out.println("printed d.plus(matrixWithNoZeroes)");
		System.out.println("-------------");
		System.out.println(d.times(matrixWithNoZeroes));
		System.out.println("printed d.times(matrixWithNoZeroes)");
		System.out.println("-------------");

		System.out.println(Arrays.deepToString(matrixWithNoZeroes.toArray()));
		System.out.println("printed matrixWithNoZeroes.toArray()");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");

		// constructor with input of double array
		double[][] inputArray = new double[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				inputArray[i][j] = i + j;
				// System.out.println(inputArray[i][j]);
			}
		}
		SquareSparseMatrix matrixFromArray = new SquareSparseMatrix(inputArray);

		System.out.println(matrixFromArray);
		System.out.println("printed matrix created from 2d array");
		System.out.println("-------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");

		// constructor with input of integer, for identity matrix
		SquareSparseMatrix idMatrix = new SquareSparseMatrix(5);
		System.out.println(idMatrix);
		System.out.println("printed identity matrix created from input of integer");
		System.out.println("-------------");
		System.out.println(SquareSparseMatrix.isIdentity(idMatrix));
		System.out.println("printed SquareSparseMatrix.isIdentity(idMatrix)");
		System.out.println("-------------");

		System.out.println(SquareSparseMatrix.isIdentity(matrixWithZeroes));
		System.out.println("printed SquareSparseMatrix.isIdentity(matrixWithZeroes)");
		System.out.println("-------------");

		System.out.println(SquareSparseMatrix.isIdentity(a));
		System.out.println("printed SquareSparseMatrix.isIdentity(a)");
		System.out.println("-------------");

		System.out.println(matrixFromArray.times(idMatrix));
		System.out.println("printed matrixFromArray.times(idMatrix)");
		System.out.println("-------------");

		System.out.println(idMatrix.times(matrixFromArray));
		System.out.println("printed idMatrix.times(matrixFromArray)");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// Test equals() method
		System.out.println(matrixFromArray.equals(matrixFromArray));
		System.out.println("printed matrixFromArray.equals(matrixFromArray)");
		System.out.println("-------------");
		System.out.println(idMatrix.equals(matrixFromArray));
		System.out.println("printed idMatrix.equals(matrixFromArray)");
		System.out.println("-------------");
		System.out.println(idMatrix.equals(matrixWithZeroes));
		System.out.println("printed idMatrix.equals(matrixWithZeroes)");
		System.out.println("-------------");

		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// try constructor with invalid inputs
		SquareSparseMatrix matrixNotSquare = new SquareSparseMatrix(3, 4);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 4; j++) {
				matrixNotSquare.set(i, j, 10.0);
			}

		System.out.println(matrixNotSquare);
		System.out.println("tried to create and print matrix that is not square");
		System.out.println("-------------");

	}
}
