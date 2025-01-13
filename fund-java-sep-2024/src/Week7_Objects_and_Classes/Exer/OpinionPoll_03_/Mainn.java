package Week7_Objects_and_Classes.Exer.OpinionPoll_03_;

import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Personn[] personnArr = new Personn[Integer.parseInt(scan.nextLine())];
        for (int i = 0; i < personnArr.length; i++) {
            String[] input = scan.nextLine().split(" ");
            personnArr[i] = new Personn(input[0], Integer.parseInt(input[1]));
        }

        for (Personn p : personnArr) {
            if (p.age > 30) {
                System.out.printf("%s - %d%n", p.firstName, p.age);
            }
        }
    }
}
