import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine(), "\\s+");

        int rows = rowsAndCols[0];

        int[][] matrix = readMatrix(rows, 0, scanner, "\\s+");

        int[] positions = readArray(scanner.nextLine(), "\\s+");

        int checker = matrix[positions[0]][positions[1]];
        int[][] finalMatrix = new int[matrix.length][matrix[rows-1].length];
        for (int row= 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if(matrix[row][col]==checker){
                            matrix[row][col] = 0;
                    if(col-1>=0&&(col-1)<matrix[row].length&&matrix[row][col-1]!=checker) finalMatrix[row][col]+=matrix[row][col-1];
                    if(col+1>=0&&(col+1)<matrix[row].length&&matrix[row][col+1]!=checker) finalMatrix[row][col]+=matrix[row][col+1];
                    if(row-1>=0&&(row-1)<matrix.length&&matrix[row-1][col]!=checker) finalMatrix[row][col]+=matrix[row-1][col];
                    if(row+1>=0&&(row+1)<matrix.length&&matrix[row+1][col]!=checker) finalMatrix[row][col]+=matrix[row+1][col];
                }else{
                    finalMatrix[row][col]=matrix[row][col];
                }
            }
        }

        printMatrix(finalMatrix);
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
