import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scan);
        int number = Integer.parseInt(scan.nextLine());
        List<int[]> output = findNumberOccurrences(matrix, number);

        if(output.isEmpty())
        {
            System.out.println(("not found"));
        }

        for(int[] indexes:output){
            System.out.println(indexes[0]+" "+indexes[1]);
        }

    }

    private static List<int[]> findNumberOccurrences(int[][] matrix, int number) {
        List<int[]> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    output.add(new int[]{row, col});
                }
            }
        }
        return output;
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
