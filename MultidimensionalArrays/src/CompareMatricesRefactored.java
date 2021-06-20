import java.util.Arrays;
import java.util.Scanner;

public class CompareMatricesRefactored {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //take first line input, divide it by " " and add values to int array
        int[] rowsAndCols = readArray(scan.nextLine());
        int rows = rowsAndCols[0];// first value from the int array is the rows of the matrix
        int cols = rowsAndCols[1];// second value from the int array is the cols of the matrix
        int[][] matrix = readMatrix(rows,cols,scan);

        rowsAndCols = readArray(scan.nextLine());
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];
        int[][] secondMatrix = readMatrix(rows, cols, scan);

        /*output with 2 for loops with available access
          for(int row =0; row<matrix.length;row++){
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }*/

        /*printMatrix(matrix);
        printMatrix(secondMatrix);*/

        if (matricesAreEqual(matrix, secondMatrix))
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {

        if(first.length!= second.length) {
            return false;
        }
        for(int row = 0; row<first.length; row++)
        {
            int[] firstArray = first[row];
            int[] secondArray = second[row];

            if(firstArray.length!=secondArray.length){
                return false;
            }

            for(int col = 0; col<firstArray.length;col++){
                if(firstArray[col]!=secondArray[col]){
                        return false;
                }
            }
        }

        return true;
    }

    //prints matrix values using for each
    public static void printMatrix(int[][] matrix){
        //output array with no available access
        for(int[] arr: matrix){
            for(int element: arr){
                System.out.print(element+" ");
            }

            System.out.println();
        }
    }

        // Scans input and divides individual values in an int[] array
    public static int[] readArray(String line){

        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scan){
        int[][] matrix = new int[rows][cols];

        for(int row = 0;row<rows;row++){
            matrix[row] = readArray(scan.nextLine());
        }
        return matrix;
    }

}
