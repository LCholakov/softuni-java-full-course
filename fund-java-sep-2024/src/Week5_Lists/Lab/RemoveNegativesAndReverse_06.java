package Week5_Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) < 0) {
                numList.remove(i);
                --i;
            }
        }

        if (numList.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numList);
            System.out.println(numList.toString()
                    .replaceAll("[\\[\\],]", ""));
        }
    }
}
