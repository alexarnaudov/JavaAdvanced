import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsPractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] parts = input.split(", ");
            if (parts[0].equals("IN")) {
                parkingLot.add(parts[1]);
            } else {
                parkingLot.remove(parts[1]);
            }
            input = scan.nextLine();
        }

        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }

    }
}
