package Week4_Methods.Lab;

import java.util.Scanner;

public class Grades_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printGradeStr(Double.parseDouble(scanner.nextLine()));
    }

    private static void printGradeStr(double d) {
        if (Double.compare(d, 5.5) >= 0) {
            System.out.println("Excellent");
        } else if (Double.compare(d, 4.5) >= 0) {
            System.out.println("Very good");
        } else if (Double.compare(d, 3.5) >= 0) {
            System.out.println("Good");
        } else if (Double.compare(d, 3.0) >= 0) {
            System.out.println("Poor");
        } else {
            System.out.println("Fail");
        }
    }
}
