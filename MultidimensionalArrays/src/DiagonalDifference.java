import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int[][] matrix = readMatrix(size, size, scanner, "\\s+");

        for (int i = 0; i < size; i++) {
            primaryDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[i][size-1-i];

        }

        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));


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
