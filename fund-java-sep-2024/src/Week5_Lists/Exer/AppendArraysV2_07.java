package Week5_Lists.Exer;

import java.nio.file.LinkPermission;
import java.util.*;
import java.util.stream.Collectors;

public class AppendArraysV2_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.asList(scanner.nextLine().split("[ ]*[|][ ]*"));
        Collections.reverse(input);

        List<String> tempList = new ArrayList<>();
        String output = "";

        for (int i = 0; i < input.size(); i++) {
            String[] numbers = input.get(i).split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                if (!numbers[j].equals("")) {
                    output = output + numbers[j] + " ";
                    tempList.add(numbers[j]);
                }
            }
        }

        String print = tempList.toString().trim();
        System.out.println(print.replaceAll("\\[|,|\\]", ""));
        System.out.println(output);

//        //regex to replace 2 or more spaces with one to normalize data
//        for (int i = 0; i < input.size(); i++) {
//            input.set(i, input.get(i).replaceAll("  +", " "));
//        }
//
//        String print = "";
//        for (String s : input) {
//            print = print + " " + s;
//        }
//        print = print.trim();
//
//        System.out.println(print.replaceAll("\\[|,|\\]", ""));
    }
}
