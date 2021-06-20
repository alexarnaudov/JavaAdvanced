import java.util.Scanner;

public class FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] queens = readMatrix(scanner);
        boolean isValid = false;
        int resultCols = 0;
        int resultRows = 0;

        for (int rows = 0; rows < queens.length; rows++) {
            for (int cols = 0; cols < queens[rows].length; cols++) {
                if(queens[rows][cols]=='q')isValid = checkQueens(queens,queens[rows][cols],rows, cols);

                if(isValid)
                {
                    resultRows = rows;
                    resultCols = cols;
                    isValid=false;
                    break;
                }

            }
        }

        System.out.println(resultRows+" "+resultCols);

    }

    private static boolean checkQueens(char[][] queens, char c, int rows, int cols) {
        boolean isValid = true;
        //up
        //down
        for(int i = 0;i< queens.length ;i++){
            if(queens[i][cols]==c&&i!=rows){
                isValid = false;
                break;
            }

        }
        //left
        //right
        for(int i = 0;i< queens.length ;i++){
            if(queens[rows][i]==c&&i!=cols) {
                isValid = false;
                break;
            }

        }
        //upLeftDiagonal
        int diagonal = rows;
        for (int i = cols; i>=0 ; i--) {
            if(queens[diagonal][i]==c&&i!=cols){
                isValid = false;
                break;
            }
            diagonal--;
            if(diagonal<0) break;
        }
        //downLeftDiagonal
         diagonal = rows;
        for (int i = cols; i>=0 ; i--) {
            if(queens[diagonal][i]==c&&i!=cols){
                isValid = false;
                break;
            }
            diagonal++;
            if(diagonal>7) break;
        }
        //upRightDiagonal
        diagonal = cols;
        for (int i = rows; i>=0 ; i--) {
            if(queens[i][diagonal]==c&&i!=rows){
                isValid = false;
                break;
            }
            diagonal++;
            if(diagonal>7) break;

        }
        //downRightDiagonal
        diagonal = rows;
        for (int i = cols; i<queens.length ; i++) {
            if(queens[diagonal][i]==c&&i!=cols){
                isValid = false;
                break;
            }
            diagonal++;
            if(diagonal>7)break;
        }
        return isValid;
    }

    //prints matrix values using for each
    public static void printMatrix(char[][] matrix){
        //output array with no available access
        for(char[] arr: matrix){
            for(char element: arr){
                System.out.print(element+" ");
            }

            System.out.println();
        }
    }
    private static char[][] readMatrix(Scanner scanner) {
        char [][]  matrix = new char[8][8];
        for (int row = 0; row < 8; row++){
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }
}
