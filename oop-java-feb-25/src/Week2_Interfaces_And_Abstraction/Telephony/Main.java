package Week2_Interfaces_And_Abstraction.Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> urls = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Smartphone smaho = new Smartphone(nums, urls);

        System.out.println(smaho);

    }
}
