package Week5_Lists.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        int[] bombArr = Arrays.stream(scanner.nextLine().split(" "))
                                .mapToInt(e -> Integer.parseInt(e)).toArray();


        while (numList.contains(bombArr[0])) {
            int bombLoc = numList.indexOf(bombArr[0]);
            int bombPow = bombArr[1];
            for (int i = bombLoc + bombPow; i >= bombLoc - bombPow; i--) {
                if(i >= 0 && i < numList.size())
                    numList.remove(i);
            }

//            System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
        }
//        System.out.println("out of while");
        int result = 0;
        for (int n : numList) {
            result += n;
        }
        System.out.println(result);
    }
}
