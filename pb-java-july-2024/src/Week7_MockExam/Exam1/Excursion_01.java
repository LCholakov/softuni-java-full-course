package Week7_MockExam.Exam1;

import java.util.Scanner;

public class Excursion_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nPpl = Integer.parseInt(scanner.nextLine());
        int nNights = Integer.parseInt(scanner.nextLine());
        int nTransPass = Integer.parseInt(scanner.nextLine());
        int nMuseumPass = Integer.parseInt(scanner.nextLine());

        double result = (nPpl * (nNights * 20 + nTransPass * 1.6 + nMuseumPass * 6) ) * 1.25;

        System.out.printf("%.2f", result);
    }
}
