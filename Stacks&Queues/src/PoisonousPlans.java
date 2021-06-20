import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlans {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        boolean plantsDying = true;
        int afterDays = 0;
        ArrayDeque<Integer> pesticide = new ArrayDeque<>();
        ArrayDeque<Integer> secondReserve = new ArrayDeque<>();
        for(int i = 0;i<n;i++)
        {
            pesticide.push(scan.nextInt());
        }

        while(plantsDying){

            plantsDying = false;

            while(!pesticide.isEmpty())
            {
                int currentPlant = pesticide.pop();
                if(!pesticide.isEmpty()&&currentPlant> pesticide.peek()){
                    plantsDying = true;
                }else{
                    secondReserve.push(currentPlant);
                }
            }

            while(!secondReserve.isEmpty()){
                pesticide.push(secondReserve.pop());
            }
            if(plantsDying)afterDays++;
        }


        System.out.println(afterDays);
    }
}
