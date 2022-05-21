
import java.util.*;

/**
 * This Class contains main method to run the program to create and modify
 * SymmetricMatrix.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment 2 2.3
 *
 */
class SymmetricMatrixTesterWithMain {
	public static void main(String[] args) throws HiddenStacktraceException {

		// matrix a, a full matrix without 0
		SymmetricMatrix a = new SymmetricMatrix(5);

		a.set(0, 0, 1);
		a.set(0, 1, 2);
		a.set(0, 2, 3);
		a.set(0, 3, 4);
		a.set(0, 4, 5);
		a.set(1, 1, 6);
		a.set(1, 2, 7);
		a.set(1, 3, 8);
		a.set(1, 4, 9);
		a.set(2, 2, 10);
		a.set(2, 3, 11);
		a.set(2, 4, 12);
		a.set(3, 3, 13);
		a.set(3, 4, 14);
		a.set(4, 4, 15);

		System.out.println("created symmetric matrix called a");
		System.out.println("-------------");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("at: " + i + "," + j + ": " + a.get(i, j));
				System.out.println("at: " + j + "," + i + ": " + a.get(j, i));
			}

		}

		System.out.println("Checked each element in a");
		System.out.println("-------------");

		System.out.println(a);
		System.out.println("printed a");
		System.out.println("-------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		//matrix b, contains both zero and non-zero values
		SymmetricMatrix b = new SymmetricMatrix();

		b.set(0, 0, 0);
		b.set(0, 1, 2);
		b.set(0, 2, 3);
		b.set(0, 3, 4);
		b.set(0, 4, 5);
		b.set(1, 1, 6);
		b.set(1, 2, 7);
		b.set(1, 3, 0);
		b.set(1, 4, 9);
		b.set(2, 2, 10);
		b.set(2, 3, 11);
		b.set(2, 4, 12);
		b.set(3, 3, 13);
		b.set(3, 4, 14);
		b.set(4, 4, 15);
		System.out.println(b);
		System.out.println("created symmetric matrix called b");
		System.out.println("-------------");
		System.out.println(b.get(0, 0));
		System.out.println(b.getDimension());
		System.out.println(b.getIndex(3, 3));
		System.out.println(b.getNumberOfElements());
		System.out.println("ran get(0,0), getDimension(), getIndex(3,3), getNumberOfElements() on b");
		System.out.println("-------------");

		b.set(1, 2, 50.0);
		System.out.println(b);
		System.out.println("ran b.set(1,2,50.0)");
		System.out.println("-------------");
		
		System.out.println(a.plus(b));
		System.out.println("printed a.plus(b)");
		System.out.println("-------------");
		

		System.out.println(a.times(b));
		System.out.println("printed a.times(b)");
		System.out.println("-------------");
		
		System.out.println(b.equals(b));
		System.out.println("printed b.equals(b)");
		System.out.println("-------------");

		System.out.println(b.equals(a));
		System.out.println("printed b.equals(a)");
		System.out.println("-------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		SymmetricMatrix matrixWithZero = new SymmetricMatrix(5);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrixWithZero.set(i, j, 0);
			}
		}
		System.out.println(matrixWithZero);
		System.out.println("created an all zero matrix called matrixWithZero");
		System.out.println("-------------");

		System.out.println(a.plus(matrixWithZero));
		System.out.println("printed a.plus(matrixWithZero))");
		System.out.println("-------------");


		System.out.println(a.times(matrixWithZero));
		System.out.println("printed a.times(matrixWithZero))");
		System.out.println("-------------");
		
		System.out.println(Arrays.deepToString(matrixWithZero.toArray()));
		System.out.println("converted the zero matrix to array");
		System.out.println("-------------");
		
		System.out.println(b.equals(matrixWithZero));
		System.out.println("printed b.equals(matrixWithZero)");
		System.out.println("-------------");

		

		System.out.println(matrixWithZero.equals(matrixWithZero));
		System.out.println("printed matrixWithZero.equals(matrixWithZero)");
		System.out.println("-------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		

		// constructor with input of double array
		double[][] inputArray = new double[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				inputArray[i][j] = i + j;
				System.out.println(inputArray[i][j]);
			}
		}
		SymmetricMatrix matrixFromArray = new SymmetricMatrix(inputArray);

		System.out.println(matrixFromArray);
		System.out.println("printed matrix created from 2d array");
		System.out.println("-------------");

		System.out.println(Arrays.deepToString(matrixFromArray.toArray()));
		System.out.println("converted the matrix back to array");
		System.out.println("-------------");

		System.out.println(Arrays.deepToString(a.toArray()));
		System.out.println("converted matrix a to array");
		System.out.println("-------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		

		SymmetricMatrix identityMatrix = new SymmetricMatrix(5, "identity");
		System.out.println(identityMatrix);
		System.out.println("printed identity matrix created");
		System.out.println("-------------");

		SymmetricMatrix identityMatrixWithNoKeyword = new SymmetricMatrix(5, "");
		System.out.println(identityMatrixWithNoKeyword);
		System.out.println("printed identityMatrixWithNoKeyword created");
		System.out.println("-------------");

		System.out.println(SymmetricMatrix.isIdentity(identityMatrix));
		System.out.println("printed isIdentity(identityMatrix)");
		System.out.println("-------------");

		System.out.println(SymmetricMatrix.isIdentity(identityMatrixWithNoKeyword));
		System.out.println("printed isIdentity(identityMatrixWithNoKeyword)");
		System.out.println("-------------");

		System.out.println(SymmetricMatrix.isIdentity(a));
		System.out.println("printed isIdentity(a)");
		System.out.println("-------------");

		System.out.println(SymmetricMatrix.isIdentity(matrixWithZero));
		System.out.println("printed isIdentity(matrixWithZero)");
		System.out.println("-------------");
		
		System.out.println(identityMatrix.times(b));
		System.out.println("printed identityMatrix.times(b)");
		System.out.println("-------------");

		System.out.println(b.times(identityMatrix));
		System.out.println("printed b.times(identityMatrix)");
		System.out.println("-------------");

		System.out.println(b.equals(identityMatrix));
		System.out.println("printed b.equals(identityMatrix)");
		System.out.println("-------------");
		

		

	}
}
