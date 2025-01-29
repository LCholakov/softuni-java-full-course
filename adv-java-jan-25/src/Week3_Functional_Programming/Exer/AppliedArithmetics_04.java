package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());

        String cmd = scan.nextLine();

        Function<Integer, Integer> funcAdd = num -> num + 1;
        Function<Integer, Integer> funcMult = num -> num * 2;
        Function<Integer, Integer> funcSubtr = num -> num -1 ;
        Consumer<Integer> consumPrint = num -> System.out.printf("%d ", num);

        while (!cmd.equals("end")) {
            switch (cmd) {
                case "add" -> numList = numList.stream().map(funcAdd).collect(Collectors.toList());
                case "multiply" -> numList = numList.stream().map(funcMult).collect(Collectors.toList());
                case "subtract" -> numList = numList.stream().map(funcSubtr).collect(Collectors.toList());
                case "print" -> {
                    numList.forEach(consumPrint);
                    System.out.println();
                }
            }
            cmd = scan.nextLine();
        }
    }
}
