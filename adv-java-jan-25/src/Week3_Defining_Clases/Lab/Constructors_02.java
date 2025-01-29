package Week3_Defining_Clases.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Constructors_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] input = scan.nextLine().split("\\s+");
            if (input.length == 1) {
                cars.add(new Car(input[0]));
            } else {
                cars.add(new Car(input[0], input[1], Integer.parseInt(input[2])));
            }
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
