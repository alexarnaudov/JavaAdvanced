import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] expression = input.split(" ");
        int precedence = 0;
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (int i = 0;i<expression.length;i++) {
            String token = expression[i];
            if (Character.isDigit(token.charAt(0)) || Character.isLetter(token.charAt(0))) {
                System.out.print(token + " ");
            } else if (token.equals("%") || token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")) {
                switch (token) {
                    case "/":
                    case "*":
                        precedence = 2;
                        break;
                    case "+":
                    case "-":
                        precedence = 1;
                        break;
                    default:
                        break;
                }
                while ((!operatorStack.isEmpty()) &&
                        (!token.equals(")")) &&
                        ((precedence == 2 && (operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))) || (precedence == 1 && (operatorStack.peek().equals("/") || operatorStack.peek().equals("*"))) ||
                                (precedence == 1 && (operatorStack.peek().equals("+") || operatorStack.peek().equals("-"))))


                ) {
                    System.out.print(operatorStack.pop() + " ");
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    System.out.print(operatorStack.pop() + " ");
                }
                if (operatorStack.peek().equals("(")) operatorStack.pop();
            }
        }

        while(!operatorStack.isEmpty())
        {
            System.out.print(operatorStack.pop()+" ");
        }
    }
}
