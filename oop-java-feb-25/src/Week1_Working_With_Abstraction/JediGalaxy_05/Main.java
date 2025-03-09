package Week1_Working_With_Abstraction.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // size[0] = rows
        // size[1] = cols
        int[] size = readPositions(scanner.nextLine());
        Galaxy galaxy = new Galaxy(size[0], size[1]);

        String cmd = scanner.nextLine();
        long sumPlayerPower = 0;
        while (!cmd.equals("Let the Force be with you")) {
            int[] playerPos = readPositions(cmd);
            int playerRow = playerPos[0];
            int playerCol = playerPos[1];

            int[] enemyPos = readPositions(scanner.nextLine());
            int enemyRow = enemyPos[0];
            int enemyCol = enemyPos[1];

            galaxy.moveEnemy(enemyRow, enemyCol);
            sumPlayerPower += galaxy.movePlayer(playerRow, playerCol);

            cmd = scanner.nextLine();
        }
        System.out.println(sumPlayerPower);
    }

    private static int[] readPositions(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
