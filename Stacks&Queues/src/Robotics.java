import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputRobots = scan.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTime(robotsData);
        String startTime = scan.nextLine(); // taking in start time
        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scan.nextLine();//End or product
        while(!product.equals("End")){
            products.offer(product);
            product = scan.nextLine();
        }

        while(!products.isEmpty()){
            String currentProduct = products.poll();
            startTimeInSeconds++;
            //reduce work time for all robots where we have a product
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            //check which robot is free -> working time = 0
            for(Map.Entry<String, Integer> robot:robotsWorkingTime.entrySet()){
                if(robot.getValue() == 0){//robot is free -> robot can start working through products
                 //startTimeInSeconds - in hours::minutes::seconds
                    System.out.println(robot.getKey()+" - "+currentProduct+" ["+getStartTime(startTimeInSeconds)+"]");
                     robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));// the working/unavailable time for this robot is increased by the Robots Map value that we got from input
                    isTaken = true;
                    break;
                }
            }
            if(!isTaken){
                products.offer(currentProduct);
            }
        }

    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for(Map.Entry<String, Integer> robot: robotsWorkingTime.entrySet()){
            if(robot.getValue()>0){//robot is not free time!= 0 it is currently working
                 robotsWorkingTime.put(robot.getKey(), robot.getValue()-1);
            }
        }
    }

    private static String getStartTime(int startTimeInSeconds){
        //from seconds to hours::minutes::seconds
        int hours = (startTimeInSeconds/3600)%24;
        int minutes = startTimeInSeconds%3600/60;
        int seconds = startTimeInSeconds%60;
        return String.format("%02d:%02d:%02d",hours, minutes, seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTime(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for(String robotData: robotsData){ //traversing robots input and allocating it into a LinkedHashMap
            //robotData = "ROB-15";->split("-")->["ROB","15"], LinkedHashMap<String, Integer> robots
            String robotName = robotData.split("-")[0];//->"ROB"
            robots.put(robotName, 0);

        }
        return robots;

    }

    private static int  getStartTimeInSeconds (String startTime) {
        //transform start time into seconds
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours*3600+minutes*60+seconds;
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for(String robotData: robotsData){ //traversing robots input and allocating it into a LinkedHashMap
            //robotData = "ROB-15";->split("-")->["ROB","15"], LinkedHashMap<String, Integer> robots
            String robotName = robotData.split("-")[0];//->"ROB"
            int processingTime = Integer.parseInt(robotData.split("-")[1]);//->"15"
            robots.put(robotName, processingTime);

        }
        return robots;
    }
}
