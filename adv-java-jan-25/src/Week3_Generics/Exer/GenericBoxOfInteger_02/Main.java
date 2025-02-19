package Week3_Generics.Exer.GenericBoxOfInteger_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box<Integer> strBox = new Box<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            strBox.add(Integer.parseInt(scan.nextLine()));
        }

        System.out.println(strBox.toString());
    }
}