package Week4_Methods.More;

import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "int" -> System.out.println(mutateData(Integer.parseInt(scanner.nextLine())));
            case "real" -> System.out.printf("%.2f", mutateData(Double.parseDouble(scanner.nextLine())));
            case "string" -> System.out.println(mutateData(scanner.nextLine()));
        }

    }

    private static int mutateData(int n) {
        return n * 2;
    }
    private static double mutateData(double d) {
        return d * 1.5;
    }
    private static String mutateData(String s) {
        return "$" + s + "$";
    }
}
