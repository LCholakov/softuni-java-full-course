package Week1_Encapsulation.AnimalFarm_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Chicken chick = new Chicken(scan.nextLine(), Integer.parseInt(scan.nextLine()));

        System.out.println(chick);
    }
}
