import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Character> openBracket = new ArrayDeque<>();
        boolean areBalanced = false;
        for(int index = 0;index<input.length();index++){
            char currentBracket = input.charAt(index);
            if(currentBracket=='(' || currentBracket=='{'||currentBracket=='['){
                openBracket.push(currentBracket);
            }else if(currentBracket==')' || currentBracket=='}'||currentBracket==']'){
               if(openBracket.isEmpty()){
                   areBalanced = false;
                   break;
               }
                //check if last open one matches
                char lastOpenBracket = openBracket.pop();
                if(lastOpenBracket=='('&&currentBracket==')'){
                    //balanced pair
                    areBalanced = true;
                } else if(lastOpenBracket=='{'&&currentBracket=='}'){
                    //balanced pair
                    areBalanced = true;
                } else if (lastOpenBracket=='['&&currentBracket==']'){
                    //balanced pair
                    areBalanced = true;
                } else{
                    //NO balance
                    areBalanced = false;
                    break;
                }
            }//check if bracket is closed
        }
        if(areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
