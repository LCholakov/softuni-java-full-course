package Week2_Sets_And_Dictionaries.Lab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] tokens = scan.nextLine().split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = students.get(studentName);
            grades.add(grade);

        }


        students.forEach((k, v) -> {
            System.out.print(k + " -> ");
            v.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", getAvgGrade(v));
        });
    }

    private static double getAvgGrade(List<Double> v) {
        double sum = 0.0;
        for (Double grade : v) {
            sum += grade;
        }

        return sum / v.size();
//        DoubleSummaryStatistics stats = v.stream()
//                .collect(Collectors.summarizingDouble(Double::doubleValue));
//        return stats.getAverage();
    }
}
