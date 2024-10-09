package Week1_BasicSyntaxReview.Lab;

import java.util.Scanner;

public class StudentInformation_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        float grade = Float.parseFloat(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
    }
}
