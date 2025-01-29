package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());

        System.out.println(Collections.min(numList));
    }
}
