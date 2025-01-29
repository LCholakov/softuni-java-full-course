package Week2_Sets_And_Dictionaries.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat decFormat = new DecimalFormat("0.#######");
        Map<String, Double> students = new TreeMap<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double avgScore = getaAvgScore(grades);

            students.put(name, avgScore);

        }

        students.forEach((k, v) -> {
            System.out.printf("%s is graduated with %.3f%n", k, decFormat.format(v));
        });
    }

    private static double getaAvgScore(double[] grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }
}
