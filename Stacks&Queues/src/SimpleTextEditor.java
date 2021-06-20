import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine()); // number of commands

        ArrayDeque<String> textState = new ArrayDeque<>();
        String textEditor = "";
        for(int i = 0;i<n;i++)
        {
            String command = scan.nextLine();

            switch (command.split(" ")[0])
            {
                case "1"://command 1 [string] - appends string at the end of text
                    textState.push(textEditor);
                    textEditor=textEditor.concat(command.split(" ")[1]);
                    break;
                case "2"://command 2 [count] - erases [count] elements
                    textState.push(textEditor);
                    textEditor = textEditor.substring(0,textEditor.length()-Integer.parseInt(command.split(" ")[1]));
                    break;
                case "3"://command 3 [index] - returns the element at position [index]
                    System.out.println(textEditor.charAt(Integer.parseInt(command.split(" ")[1])-1));
                    break;
                case "4"://command 4 - undoes the last non-undone command of type 1 or 2 and returns the text before that operation

                    if(!textState.isEmpty())
                    {
                        textEditor = textState.pop();
                    }
                    break;
                default:
                    break;
            }

        }

    }
}
