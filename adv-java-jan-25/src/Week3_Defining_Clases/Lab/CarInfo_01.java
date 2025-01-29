package Week3_Defining_Clases.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInfo_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] input = scan.nextLine().split("\\s+");
            Car c = new Car();
            c.setBrand(input[0]);
            c.setModel(input[1]);
            c.setHorsePower(Integer.parseInt(input[2]));
            cars.add(c);
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
