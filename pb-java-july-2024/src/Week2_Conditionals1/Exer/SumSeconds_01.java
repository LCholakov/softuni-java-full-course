package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class SumSeconds_01
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input1 = Integer.parseInt(scanner.nextLine());
        int input2 = Integer.parseInt(scanner.nextLine());
        int input3 = Integer.parseInt(scanner.nextLine());

        int sumInputs = input1 + input2 + input3;
        int min = sumInputs / 60;
        int sec = sumInputs - min * 60;

        System.out.printf("%d:%02d", min, sec);
    }
}