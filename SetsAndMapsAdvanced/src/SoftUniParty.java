import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> guestList = new TreeSet<>();
        TreeSet<String> vipGuestList = new TreeSet<>();
        String input = scan.nextLine();
        while(!input.equals("PARTY")){
            char check = input.charAt(0);
            if(Character.isDigit(check))
            {
                vipGuestList.add(input);
            }
            else
            {
                guestList.add(input);
            }

            input = scan.nextLine();
        }

        while(!input.equals("END")){
            char check = input.charAt(0);
            if(Character.isDigit(check))
            {
                vipGuestList.remove(input);
            }
            else
            {
                guestList.remove(input);
            }

            input = scan.nextLine();
        }

        System.out.println(guestList.size()+ vipGuestList.size());
        printSetIfNotEmpty(vipGuestList);
        printSetIfNotEmpty(guestList);
    }

    public static void printSetIfNotEmpty(Set<String> set){
            if(!set.isEmpty()){
                System.out.println(String.join(System.lineSeparator(),set));
            }
    }
}
