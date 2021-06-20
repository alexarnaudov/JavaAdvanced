import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                infoTable = new LinkedHashMap<>();

        while(n-- >0){
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            infoTable.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> innerMap = infoTable.get(continent);
            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);
        }

        for(var entry:infoTable.entrySet()){
            String continent = entry.getKey();
            LinkedHashMap<String, List<String>> innerMap = entry.getValue();
            System.out.println(continent+":");

            for (var innerEntry:innerMap.entrySet()) {
                System.out.println("  "+innerEntry.getKey()+" -> "+String.join(", "
                ,innerEntry.getValue()));
            }
        }

    }
}
