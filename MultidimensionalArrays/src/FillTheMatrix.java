import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);
        int[][] matrix = new int[size][size];
        int counter = 1;

        if(type=='A')
        {
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    matrix[cols][rows] = counter;
                    counter++;
                }
            }
        } else if (type=='B'){
            for (int rows = 0; rows < matrix.length; rows++) {

                if(rows%2==1)
                {
                    for (int cols = matrix[rows].length-1; cols >=0 ; cols--) {

                        matrix[cols][rows] = counter;
                        counter++;
                    }
                }else{
                    for (int cols = 0; cols < matrix[rows].length; cols++) {

                        matrix[cols][rows] = counter;
                        counter++;
                    }
                }

            }
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
