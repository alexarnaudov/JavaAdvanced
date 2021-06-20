import java.util.Arrays;
import java.util.Scanner;

public class MatrixShufling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine(), "\\s+");
        String[][] matrix = new String[rowsAndCols[0]][rowsAndCols[1]];

        readMatrix(rowsAndCols[0], rowsAndCols[1], scanner, matrix);

        String input = scanner.nextLine();

        while(!input.equals("END")){

            if(!validateCommand(input, rowsAndCols[0], rowsAndCols[1]))
            {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }else{
                String[] tokens = input.split(" ");
                int rowFirst = Integer.parseInt(tokens[1]);
                int colFirst = Integer.parseInt(tokens[2]);
                int rowSecond = Integer.parseInt(tokens[3]);
                int colSecond= Integer.parseInt(tokens[4]);

                String element1 = matrix[rowFirst][colFirst];
                String element2 = matrix[rowSecond][colSecond];
                matrix[rowFirst][colFirst] = element2;
                matrix[rowSecond][colSecond]= element1;

                printMatrix(matrix);
            }

            input = scanner.nextLine();
        }

    }

    private static boolean validateCommand(String command, int rows, int cols){
        String[] tokens = command.split(" ");
        String commandName = tokens[0];
        if(!commandName.equals("swap")){
            return false;
        }

        if(tokens.length!=5){
            return false;
        }
        int rowFirst = Integer.parseInt(tokens[1]);
        int colFirst = Integer.parseInt(tokens[2]);
        int rowSecond = Integer.parseInt(tokens[3]);
        int colSecond= Integer.parseInt(tokens[4]);

        if(rowFirst<0||rowFirst>=rows||colFirst<0||
                colFirst>=cols||rowSecond<0||rowSecond>=rows||colSecond<0||
                colSecond>=cols){
            return false;
        }

        return true;
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
        for(String[] arr: matrix){
            for(String element: arr){
                System.out.print(element+" ");
            }

            System.out.println();
        }
    }
}
