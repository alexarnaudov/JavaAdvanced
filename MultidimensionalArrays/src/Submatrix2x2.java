import java.util.Arrays;
import java.util.Scanner;

public class Submatrix2x2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");

        int rows =rowsAndCols[0];
        int cols =rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
 int maxSum = 0;
 int bestCol = 0;
 int bestRow = 0;
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                int sum =
                        matrix[row][col]+
                                matrix[row][col+1]+
                                matrix[row+1][col]+
                                matrix[row+1][col+1];
                if(sum>maxSum){
                    maxSum=sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println(matrix[bestRow][bestCol]+" "+matrix[bestRow][bestCol+1]);
        System.out.println(matrix[bestRow+1][bestCol]+" "+matrix[bestRow+1][bestCol+1]);
        System.out.println(maxSum);
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
    public static int[] readArray(String line, String pattern){

        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scan, String pattern){
        int[][] matrix = new int[rows][cols];

        for(int row = 0;row<rows;row++){
            matrix[row] = readArray(scan.nextLine(), pattern);
        }
        return matrix;
    }
}
