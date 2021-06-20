import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = readArray(scanner.nextLine(), "\\s+");
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];
        char starLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                String palindrome = ""+starLetter+(char)(starLetter+col)+starLetter;
                matrix[row][col] = palindrome;
            }
            starLetter = (char)(starLetter+1);
        }

        printMatrix(matrix);

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
    public static void printMatrix(String[][] matrix){
        //output array with no available access
        for(String[] arr: matrix){
            for(String element: arr){
                System.out.print(element+" ");
            }

            System.out.println();
        }
    }
}
