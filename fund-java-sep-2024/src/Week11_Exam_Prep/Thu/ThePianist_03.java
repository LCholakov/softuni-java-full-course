package Week11_Exam_Prep.Thu;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, String[]> pieceMap = new LinkedHashMap<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String[] piece = scan.nextLine().split("\\|");
            String[] temp = {piece[1], piece[2]};
            pieceMap.put(piece[0], temp);
        }

        String[] cmd = scan.nextLine().split("\\|");
        while (!cmd[0].equals("Stop")) {
            switch (cmd[0]) {
                case "Add" -> {
                    if (pieceMap.containsKey(cmd[1])) {
                        System.out.println(cmd[1] + " is already in the collection!");
                    } else {
                        String[] temp = {cmd[2], cmd[3]};
                        pieceMap.put(cmd[1], temp);
                        System.out.printf("%s by %s in %s added to the collection!%n", cmd[1], cmd[2], cmd[3]);
                    }
                }
                case "Remove" -> {
                    if (pieceMap.containsKey(cmd[1])) {
                        pieceMap.remove(cmd[1]);
                        System.out.printf("Successfully removed %s!%n", cmd[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", cmd[1]);
                    }
                }
                case "ChangeKey" -> {
                    if (pieceMap.containsKey(cmd[1])) {
                        pieceMap.get(cmd[1])[1] = cmd[2];
                        System.out.printf("Changed the key of %s to %s!%n", cmd[1], cmd[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", cmd[1]);
                    }
                }
            }
            cmd = scan.nextLine().split("\\|");
        }

        for(Map.Entry<String, String[]> e : pieceMap.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue()[0], e.getValue()[1]);
        }
    }
}