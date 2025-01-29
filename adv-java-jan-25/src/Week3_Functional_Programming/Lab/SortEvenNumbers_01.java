package Week3_Functional_Programming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        List<Integer> numList = new java.util.ArrayList<>(Arrays.stream(scan.nextLine().split(", "))
//                .map(Integer::parseInt)
//                .toList());

//        numList.removeIf(n -> n % 2 != 0);

        List<Integer> numList = new java.util.ArrayList<>(Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter((n -> n % 2 == 0))
                .toList());

        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));

        Collections.sort(numList);
        
        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
    }
}
