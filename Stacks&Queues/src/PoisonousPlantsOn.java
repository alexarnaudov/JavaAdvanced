import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlantsOn {
  int valuePesticide;
  int valueDays;

  public PoisonousPlantsOn(int a, int b){
      valuePesticide = a;
      valueDays = b;
  }

    public PoisonousPlantsOn(PoisonousPlantsOn a){
        valuePesticide = a.valuePesticide;
        valueDays = a.valueDays;
    }

    public PoisonousPlantsOn() {

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] pesticide = new int[n];
        for(int i = 0;i<n;i++)
        {
            pesticide[i] = scan.nextInt();
        }
        int daysAfter=0;
        ArrayDeque<PoisonousPlantsOn> pesticidesStack = new ArrayDeque<>();
        for(int i = 0;i<n;i++)
        {
            if(pesticidesStack.isEmpty()){

                pesticidesStack.push(new PoisonousPlantsOn(pesticide[i],0));

            }else{
                PoisonousPlantsOn temp = pesticidesStack.peek();
                if(pesticide[i]>temp.valuePesticide)
                {
                    daysAfter = Math.max(daysAfter,1);
                    pesticidesStack.push(new PoisonousPlantsOn(pesticide[i],1));
                }
                else
                {
                    PoisonousPlantsOn v = pesticidesStack.peek();
                    int counter = v.valueDays;
                    while(!pesticidesStack.isEmpty()&&v.valuePesticide>=pesticide[i]){
                        pesticidesStack.pop();
                        if(pesticidesStack.isEmpty()) break;
                        counter = Math.max(counter,v.valueDays);
                        v = pesticidesStack.peek();
                    }
                    if(pesticidesStack.isEmpty())
                    {
                        pesticidesStack.push(new PoisonousPlantsOn(pesticide[i],0));
                    }
                    else
                    {
                        pesticidesStack.push(new PoisonousPlantsOn(pesticide[i],counter+1));
                        daysAfter= Math.max(daysAfter,counter+1);
                    }

                }
            }
        }
        System.out.println(daysAfter);

    }
}
