import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Crossfire {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine(), "\\s+");
        String[][] matrix = new String[rowsAndCols[0]][rowsAndCols[1]];
            int n = 1;
        for (int rows = 0; rows < rowsAndCols[0]; rows++) {
            for (int cols = 0; cols < rowsAndCols[1]; cols++) {
                matrix[rows][cols] = ""+n;
                n++;
            }
        }

        String input = scan.nextLine();

        while(!input.equals("Nuke it from orbit")){


            String[] tokens = input.split(" ");
            int rows = Integer.parseInt(tokens[0]);
            int cols = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);
            //top to bottom
            for (int range = rows - radius; range <= rows+radius ; range++) {
                if (isInTheMatrix(range,cols,matrix)) {
                    //delete member
                    matrix[range][cols] = null;
                }
            }

            //left to right
            for (int range = cols-radius; range <= cols+radius ; range++) {
                if(isInTheMatrix(rows,range,matrix)){
                    //delete member
                    matrix[rows][range] = null;
                }
            }

            matrix = clearEmptyCells(matrix);
            input = scan.nextLine();
        }

        printMatrix(matrix);
    }

    // Scans input and divides individual values in an int[] array
    public static int[] readArray(String line, String pattern){

        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void readMatrix(int rows, int cols, Scanner scan, String[][] matrix){
        for(int row = 0;row<rows;row++){
            matrix[row] = scan.nextLine().split("\\s+");
        }
    }

    //prints matrix values using for each
    public static void printMatrix(String[][] matrix){
        //output array with no available access
        for (String[] line : matrix) {
            StringBuilder sb = new StringBuilder();
            for (String cell : line) {
                sb.append(cell).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
    private static boolean isInTheMatrix(int currentRow, int currentCol, String[][] matrix) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }
    private static String[][] clearEmptyCells(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i]).filter(s -> s != null).toArray(String[]::new);
        }
        matrix = Arrays.stream(matrix).filter(l -> l.length > 0).toArray(String[][]::new);
        return matrix;
    }
}
