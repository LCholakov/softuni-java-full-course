package Week5_Lists.Exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nameList = new ArrayList<>();
        for (int i = Integer.parseInt(scanner.nextLine()); i > 0; i--) {
            String[] input = scanner.nextLine().split(" ");
            if ((input[1] + input[2]).equals("isgoing!")) {
                if(nameList.contains(input[0]))
                    System.out.println(input[0] + " is already in the list!");
                else
                    nameList.add(input[0]);
            } else {
                if(nameList.contains(input[0]))
                    nameList.remove(input[0]);
                else
                    System.out.println(input[0] + " is not in the list!");
            }
        }

        nameList.forEach(System.out::println);
    }
}
