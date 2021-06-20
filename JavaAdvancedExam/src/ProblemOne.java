import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task - stack
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        //thread - queue
        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));// calls add()

        int taskToKill = Integer.parseInt(scanner.nextLine());
        int killerThread = 0;
        int currentThread = threads.peek();
        int currentTask = tasks.peek();

        do {
            currentThread = threads.peek();
            currentTask = tasks.peek();
            if(currentThread>=currentTask){
                if(currentTask==taskToKill)
                {
                    killerThread=currentThread;
                    break;
                }
                threads.poll();
                tasks.pop();
            } else {
                if(currentTask==taskToKill)
                {
                    killerThread=currentThread;
                    break;
                }
                threads.poll();
            }
        }while(currentTask!=taskToKill);

        System.out.printf("Thread with value %d killed task %d%n",killerThread,taskToKill);
        System.out.println(getElementsInfo(threads));
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ?"none"
                :deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
/*
    The OS works in the following way:
            •	It takes the first given thread value and the last given task value.
         	If the thread value is greater than or equal to the task value, the task and thread get removed.
            •	If the thread value is less than the task value, the thread gets removed, but the task remains.*/

}
