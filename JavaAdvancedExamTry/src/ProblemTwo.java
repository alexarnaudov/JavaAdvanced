import java.util.Scanner;

public class ProblemTwo {

    public static int startRow;
    public static int startCol;
    public static int foodCount;
    public static int pythonLength;
    public static boolean isAlive = true;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get size and set matrix rows & cols
        n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        startRow = 0;
        startCol = 0;
        foodCount = 0;
        pythonLength = 1;
        //get input and separate it into a string array
        String input = scanner.nextLine();
        String[] commands = input.split(", ");
        int commandsSize = 0;
        //fill matrix
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\s+", "");
            if(line.contains("s")){
                startRow = row;
                startCol = line.indexOf("s");
            }
            if(line.contains("f")){

                for (char ch:line.toCharArray()
                     ) {
                    if(ch=='f')foodCount++;
                }

            }
            matrix[row] = line.toCharArray();
        }

        while(commandsSize<commands.length){

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
            if(!isAlive) break;

            commandsSize++;
        }


           if(foodCount==0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
            }else if(!isAlive){
            System.out.print("You lose! Killed by an enemy!");
            }else if(foodCount>0){
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
            }
        //printMatrix(matrix);

    }

    private static void move( int newRow, int newCol, char[][] matrix) {

        //up and down
        if(newRow>=matrix.length){//down
            newRow = 0;
        }else if(newRow<0){//up
            newRow=n-1;
        }

        //left and right
        if(newCol>=matrix[newRow].length) {//right
            newCol = 0;
        } else if (newCol<0){//left
                newCol = n-1;
        }


        matrix[startRow][startCol] = '*';
        //check for food and enemy and square
        if(Character.toString(matrix[newRow][newCol]).matches("f")){
            foodCount--;
            pythonLength++;
        } else if(Character.toString(matrix[newRow][newCol]).matches("e")){
            isAlive = false;
        }

        matrix[newRow][newCol] = 's';
        startRow=newRow;
        startCol=newCol;
    }

}
