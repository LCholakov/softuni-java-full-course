package Week2_Sets_And_Dictionaries.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

            double avgGrade = getAvgGrade(grades);
            students.put(name, avgGrade);
        }
        students.forEach((k, v) -> {

//            String s = new DecimalFormat("0.######").format(v);
//            https://softuni.bg/forum/37970/7-academygraduation
//            не ти трябва децимал формат , проблема е в double принта ,
//            в единия от случаите average е да речем 2.04333331249 и джъдж очаква да отпечатиш този резултат ,
//            но като му кажеш %f в стринг формата и печати 2.0433333125 , проблема си го решаваш като го печатиш с %s
//            https://github.com/Petrov-connect/Java-Advanced/blob/master/SetsAndMaps/AcademyGraduation.java

            System.out.printf("%s is graduated with %s%n", k,v.toString());
        });
    }

    private static double getAvgGrade(double[] grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
}
