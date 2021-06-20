import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rowsandCols = readArray(scan.nextLine(), ", ");


                int rows = rowsandCols[0];
                int cols = rowsandCols[1];
                int[][] matrix = readMatrix(rows,cols, scan, ", ");


        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));

    }

    private static int getElementsSum(int[][] matrix) {
        int sum = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    public static int getElementsSumWithStream(int[][] matrix){

    return Arrays.stream(matrix)
    .flatMapToInt(Arrays::stream)
            .sum();
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
