package Week1.Lab;

import java.util.Scanner;

public class Rectangle_Area_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rect side A: ");
        int sideA = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter rect side B: ");
        int sideB = Integer.parseInt(scanner.nextLine());

        int rectArea = sideA * sideB;

        System.out.println(rectArea);
    }
}
