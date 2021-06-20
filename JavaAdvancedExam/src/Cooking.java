import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));// calls add()
        //Stack and we need to call push
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);
        /*
        Check that the input is correct
        System.out.println(liquids.poll());
        System.out.println(ingredients.pop());
         */
        //make Map of food and values
        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100,"Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();
        //add cooking table initially to productsCooked
        cookingTable.values()
                .forEach(p->productsCooked.put(p,0));

        while(!liquids.isEmpty()&&!ingredients.isEmpty()){
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();
            int sum = currentIngredient+currentLiquid;
            if(ableToCookProduct(sum)){
                String product = cookingTable.get(sum);
                productsCooked.put(product, productsCooked.get(product)+1);
            }else {
                ingredients.push(currentIngredient+3);
            }
        }

        if(hasCookedEachMeal(productsCooked)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

       System.out.println("Liquids left: "+ getElementsInfo(liquids));
        System.out.println("Ingredients left: "+getElementsInfo(ingredients));

        //printing keys and values of Map productsCooked
        productsCooked.forEach((k,v)->{
            System.out.println(k+": "+v);
        });
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ?"none"
                :deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    //check if all products are cooked and return true if they are, otherwise return false
    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        return
                productsCooked.values()
                .stream()
                .noneMatch(c->c==0);
    }

    private static boolean ableToCookProduct(int sum) {
        return sum == 25||sum==50||sum==75||sum==100;
    }
}
