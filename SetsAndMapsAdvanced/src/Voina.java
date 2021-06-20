import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readDeck(scan.nextLine());
        LinkedHashSet<Integer> secondDeck = readDeck(scan.nextLine());

        int rounds = 50;

        while(rounds-- > 0)
        {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);
            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if(secondCard>firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if(firstDeck.isEmpty()||secondDeck.isEmpty()) break;
        }

        if(firstDeck.size()>secondDeck.size()) {
            System.out.println("First player win!");
        } else if (firstDeck.size()<secondDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static int getFirst(LinkedHashSet<Integer> set){
        for (Integer card : set) {
            return card;
        }
       // set.stream().findFirst();
        /*finding first value using stream
        return value using iterator
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        iterator.remove();
        return next;*/
        return 0;
    }

    private static LinkedHashSet<Integer> readDeck(String line) {
        return Arrays.stream(line.split("\\s+")) // split data by spaces
                .map(Integer::parseInt)// turn it to Int
                .collect(Collectors.toCollection(LinkedHashSet::new));// collect Ints in a set
    }
}
