import java.util.Arrays;
import java.util.Scanner;

public class Diagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), " ");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[0];

        int[][] matrix = readMatrix(rows, cols, scanner, " ");
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int[] ints : matrix) {
            System.out.print(ints[diagonal1] + " ");
            diagonal1 += 1;
        }
        System.out.println();
        for (int row = cols-1; row >= 0; row--) {
            System.out.print(matrix[row][diagonal2]+" ");
            diagonal2+=1;
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
}
