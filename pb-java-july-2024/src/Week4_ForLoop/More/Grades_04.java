package Week4_ForLoop.More;

import java.util.Scanner;

public class Grades_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());

        int num2to3 = 0;
        int num3to4 = 0;
        int num4to5 = 0;
        int numAbove5 = 0;
        double avgGrade = 0.0;
        double gradeSum = 0.0;

        for (int i = 1; i <= numStudents; ++i)
        {
            double grade = Double.parseDouble(scanner.nextLine());
            gradeSum += grade;
            if (grade < 3)
                ++num2to3;
            else if (grade < 4)
                ++num3to4;
            else if (grade < 5)
                ++num4to5;
            else
                ++numAbove5;
        }

        double perc2to3 = 100.0 * num2to3 / numStudents;
        double perc3to4 = 100.0 * num3to4 / numStudents;
        double perc4to5 = 100.0 * num4to5 / numStudents;
        double percAbove5 = 100.0 * numAbove5 / numStudents;
        avgGrade = gradeSum / numStudents;

        System.out.printf("Top students: %.2f%%%n", percAbove5);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", perc4to5);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", perc3to4);
        System.out.printf("Fail: %.2f%%%n", perc2to3);
        System.out.printf("Average: %.2f", avgGrade);
    }
}
