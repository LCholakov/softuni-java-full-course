package Week5_Lists.Exer;

import java.nio.file.LinkPermission;
import java.util.*;
import java.util.stream.Collectors;

public class AppendArraysV2_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.asList(scanner.nextLine().split("[ ]*[|][ ]*"));
        Collections.reverse(input);

        String output = "";

        for (int i = 0; i < input.size(); i++) {
            String[] numbers = input.get(i).split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                if (!numbers[j].equals("")) {
                    output = output + numbers[j] + " ";
                }
            }
        }

        System.out.println(output);
    }
}
