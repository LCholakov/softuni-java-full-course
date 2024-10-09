package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class ExamPreparation_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int maxLowGrades = Integer.parseInt(scanner.nextLine());
        int lowGradeCounter = 0;
        int assignmentCounter = 0;
        int gradeSum = 0;
        String lastAssignment = "";

        while (true)
        {
            String assignment = scanner.nextLine();
            if (assignment.equals("Enough"))
            {
                System.out.printf("Average score: %.2f%n", 1.0 * gradeSum / assignmentCounter);
                System.out.printf("Number of problems: %d%n", assignmentCounter);
                System.out.printf("Last problem: %s%n", lastAssignment);
                break;
            }

            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4)
            {
                ++lowGradeCounter;
                if (lowGradeCounter >= maxLowGrades)
                {
                    System.out.printf("You need a break, %d poor grades.", lowGradeCounter);
                    break;
                }
            }

            gradeSum += grade;
            ++assignmentCounter;
            lastAssignment = assignment;
        }
    }
}
