import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
        //push elements n times into the queue
        for(int count = 1;count<=n;count++)
        {
            queue.offer(scan.nextInt());
        }

        //pop elements s times
        for(int count=1;count<=s;count++)
        {
            queue.poll();
        }

        //x number has to be checked if present
        if(queue.contains(x))
        {
            System.out.println("true");
        } else {
            if(!queue.isEmpty())
            {
                System.out.println(getMinElementFromQueue(queue)); //Collections.min(queue);

            }else{
                System.out.println(0);

            }
        }
    }

    private static int getMinElementFromQueue(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int currentElement = queue.poll();
            if(currentElement<min)
            {
                min = currentElement;
            }
        }
        return min;
    }
}
