package Week5_Lists.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCap = Integer.parseInt(scanner.nextLine());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) { break; }
            if (input[0].equals("Add")) {
                numList.add(Integer.parseInt(input[1]));
            } else {
                int newPsngr = Integer.parseInt(input[0]);
                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) + newPsngr <= maxCap){
                        numList.set(i, numList.get(i) + newPsngr);
                        break;
                    }
                }
            }
        }

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }
}