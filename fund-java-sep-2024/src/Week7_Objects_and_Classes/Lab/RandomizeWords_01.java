package Week7_Objects_and_Classes.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        List<String> strList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

//        Collections.shuffle(strList);

        for (int i = 0; i < strList.size(); i++) {
            int newPos = rnd.nextInt(strList.size());
            String temp = strList.get(newPos);
            strList.set(newPos, strList.get(i));
            strList.set(i, temp);
        }
        System.out.println(String.join(System.lineSeparator(), strList));

    }
}
