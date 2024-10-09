package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class Graduation_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double grade = 0.0;
        double gradeSum = 0.0;
        int gradeCount = 0;

        while (gradeCount < 12)
        {
            grade = Double.parseDouble(scanner.nextLine());
            if (grade == 2)
            {
                System.out.printf("%s has been excluded at %d grade", name, gradeCount + 1);
                break;
            }

            gradeSum += grade;
            if (grade >= 4)
            {
                ++gradeCount;
            }
        }

        if (gradeCount >= 12)
            System.out.printf("%s graduated. Average grade: %.2f", name, 1.0 * gradeSum / gradeCount);
    }
}
