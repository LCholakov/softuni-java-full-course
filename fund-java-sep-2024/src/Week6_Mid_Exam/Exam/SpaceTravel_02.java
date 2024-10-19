package Week6_Mid_Exam.Exam;

import java.util.Scanner;

public class SpaceTravel_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] route = scan.nextLine().split("\\|\\|");
        int fuel = Integer.parseInt(scan.nextLine());
        int ammo = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < route.length; i++) {
            String[] cmd = route[i].split(" ");
            if (cmd[0].equals("Titan")) {
                System.out.println("You have reached Titan, all passengers are safe.");
                break;
            }
            int val = Integer.parseInt(cmd[1]);
            switch (cmd[0]) {
                case "Travel" -> {
                    if (val > fuel) {
                        System.out.println("Mission failed.");
                        break;
                    }
                    fuel -= val;
                    System.out.printf("The spaceship travelled %d light-years.%n", val);
                }
                case "Enemy" -> {
                    if (ammo >= val) {
                        ammo -= val;
                        System.out.printf("An enemy with %d armour is defeated.%n", val);
                    } else if (fuel >= 2 * val) {
                        fuel -= 2 * val;
                        System.out.printf("An enemy with %d armour is outmaneuvered.%n", val);
                    } else {
                        System.out.println("Mission failed.");
                    }
                }
                case "Repair" ->  {
                    ammo += 2 * val;
                    fuel += val;
                    System.out.printf("Ammunitions added: %d.%n", 2 * val);
                    System.out.printf("Fuel added: %d.%n", val);
                }
            }

        }
    }
}
