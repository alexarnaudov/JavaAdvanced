import java.util.Scanner;

public class ProblemTwo {

    public static int startRow;
    public static int startCol;
    public static int foodCount = 0;
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        boolean isAlive = true;
        //get size and set matrix rows & cols
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
         startRow = 0;
         startCol = 0;
        //get input and separate it into a string array
        String input = scanner.nextLine();
        String[] commands = input.split(", ");
        int commandsSize = 0;
        //fill matrix
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if(line.contains("s")){
                startRow = row;
                startCol = line.indexOf("s");
            }
            if(line.contains("f")){
                foodCount++;
            }
        }

        while(foodCount>0&&isAlive&&commandsSize<commands.length){

            //Move
            if(commands[commandsSize].equals("up"))
            {
                //up
                move( startRow-1, startCol, matrix);
            } else if(commands[commandsSize].equals("down"))
            {
                //down
                move( startRow+1, startCol, matrix);
            }else if(commands[commandsSize].equals("left"))
            {
                //left
                move( startRow, startCol-1, matrix);
            }else if(commands[commandsSize].equals("right")){
                //right
                move( startRow, startCol+1, matrix);
            }

            commandsSize++;
        }

        if(foodCount==0)
        {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        }else if(foodCount>0&&isAlive&&commandsSize==0){
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        } else if(!isAlive){
            System.out.println("You lose! Killed by an enemy!");
        }
        //printMatrix(matrix);

    }

    private static void move( int newRow, int newCol, char[][] matrix) {

      //  if(isOutOfBounds(newRow, newCol, matrix)){ }
        matrix[startRow][startCol] = '*';
        //check for food and enemy and square
        if(Character.toString(matrix[newRow][newCol]).matches("f")){
          foodCount--;
        }

        matrix[newRow][newCol] = 's';
        startRow=newRow;
        startCol=newCol;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {

        return row>=matrix.length||row<0||col>=matrix[row].length||col<0;
    }

    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println("");
        }
    }
}
