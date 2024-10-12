package Week5_Lists.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> hand1 = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> hand2 = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        while (!hand1.isEmpty() && !hand2.isEmpty()) {
            // Do stuff

            if (hand1.get(0) > hand2.get(0)) {
                hand1.add(hand1.get(0));
                hand1.remove(0);
                hand1.add(hand2.get(0));
                hand2.remove(0);
            } else if (hand1.get(0) < hand2.get(0)) {
                hand2.add(hand2.get(0));
                hand2.remove(0);
                hand2.add(hand1.get(0));
                hand1.remove(0);
            } else {
                hand1.remove(0);
                hand2.remove(0);
            }
        }
        int result = 0;
        if (hand1.size() != 0) {
            for (int n : hand1)
                result += n;
            System.out.println("First player wins! Sum: " + result);
        } else {
            for (int n : hand2)
                result += n;
            System.out.println("Second player wins! Sum: " + result);
        }
//        System.out.println(hand1.toString().replaceAll("[\\[\\],]", ""));
//        System.out.println(hand2.toString().replaceAll("[\\[\\],]", ""));
    }
}
