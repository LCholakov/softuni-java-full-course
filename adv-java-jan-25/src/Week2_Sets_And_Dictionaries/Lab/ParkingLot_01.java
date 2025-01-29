package Week2_Sets_And_Dictionaries.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input = scan.nextLine().split(",\\s");

        Set<String> parking = new LinkedHashSet<>();

        while (!input[0].equals("END")) {
            String direction = input[0];
            String carNum = input[1];

            switch (direction) {
                case "IN" -> parking.add(carNum);
                case "OUT" -> parking.remove(carNum);
            }

            input = scan.nextLine().split(",\\s");
        }

        if(parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
//            for (String carNum : parking) {
//                System.out.println(carNum);
//            }
            parking.forEach(System.out::println);
        }
    }
}
