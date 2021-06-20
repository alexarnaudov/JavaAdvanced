import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        TreeMap<String, double[]> averageGrades = new TreeMap<>();

        for (int i = 0; i < students; i++) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            averageGrades.put(name,grades);

        }

        for(var entry:averageGrades.entrySet()){
            double avg = Arrays.stream(entry.getValue()).average().orElse(0);
            System.out.printf("%s is graduated with %.3f%n", entry.getKey(), avg);

        }
    }
}
