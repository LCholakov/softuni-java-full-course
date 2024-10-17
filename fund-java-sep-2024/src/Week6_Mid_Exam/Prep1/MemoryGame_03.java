package Week6_Mid_Exam.Prep1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int moveCount = 0;
        String[] input = scan.nextLine().split(" ");
        while (!input[0].equals("end")) {
            int idx1 = Integer.parseInt(input[0]);
            int idx2 = Integer.parseInt(input[1]);
            moveCount++;
            if (!isValidInput(list, idx1, idx2)) {
                list.add(list.size() / 2, "-" + moveCount + "a");
                list.add(list.size() / 2, "-" + moveCount + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (list.get(idx1).equals(list.get(idx2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(idx1));
                // first remove the rightmost element to avoid chnging the index if it shifts.
                list.remove(Math.max(idx1, idx2));
                list.remove(Math.min(idx1, idx2));
            } else {
                System.out.println("Try again!");
            }
            if (list.isEmpty()) {
                System.out.printf("You have won in %d turns!", moveCount);
                break;
            }

            input = scan.nextLine().split(" ");
        }

        if(list.size() != 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean isValidInput(List<String> numList, int idx1, int idx2) {
        if (idx1 == idx2) {
            return false;
        }
        if (idx1 < 0 || idx2 < 0) {
            return false;
        }
        if (idx1 >= numList.size() || idx2 >= numList.size()){
            return false;
        }
        return true;
    }
}
