import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapEntries = new LinkedHashMap<>();
        for (double value:values) {
            if(!mapEntries.containsKey(value))
            {
                mapEntries.put(value, 1);
            }else{
                mapEntries.put(value, mapEntries.get(value)+1);
            }
        }
        for(Double key:mapEntries.keySet()){
            System.out.println(String.format("%.1f -> %d", key, mapEntries.get(key)));
        }
    }
}
