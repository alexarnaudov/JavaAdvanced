import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {




    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //creating a Stack
        String[] input = scan.nextLine().split(" ");//GETTING THE NUMBERS
        //["1"] ["2"] ["3"] ["4"] ["5"]
        for(String element:input)
        {
            stack.push(Integer.parseInt(element));
        }

        //stop: stack e empty
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
