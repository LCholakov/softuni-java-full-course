package Week3_Generics.Exer.GenericBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box<String> strBox = new Box<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            strBox.add(scan.nextLine());
        }

        System.out.println(strBox.toString());
    }
}
