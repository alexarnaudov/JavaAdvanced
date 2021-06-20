import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Enter matrix 1
        String input = scan.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix1 = new int[rows][cols];
        for(int row = 0; row< rows; row++)
        {
            String[] inputTokens = scan.nextLine().split(" ");
            for(int column = 0; column< cols; column++)
            {
                matrix1[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }

        //Enter matrix 2
        input = scan.nextLine();
        rows = Integer.parseInt(input.split(" ")[0]);
        cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix2 = new int[rows][cols];
        for(int row = 0; row< rows; row++)
        {
            String[] inputTokens = scan.nextLine().split(" ");
            for(int column = 0; column< cols; column++)
            {
                matrix2[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }



        if (Arrays.deepEquals(matrix1, matrix2))
            System.out.println("equal");
        else
            System.out.println("not equal");
    }


}
