package Week3_Defining_Clases.Exer.SpeedRacing_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] input = scan.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double consPerKm = Double.parseDouble(input[2]);
            int dist = 0;

            Car car = new Car(model, fuel, consPerKm, dist);

            carList.add(car);
        }

        String [] cmd = scan.nextLine().split("\\s+");
        while (!cmd[0].equals("End")) {
            String model = cmd[1];
            int dist = Integer.parseInt(cmd[2]);
            boolean canTravel = getCurrentCar(model, carList).canCoverDist(dist);
            if (canTravel) {
                Car currCar = getCurrentCar(model, carList);
                double remainingFuel = currCar.getRemainingFuel(dist);
                int carIdx = getIndexAndDelCar(currCar, carList);
                currCar.setFuelAmount(remainingFuel);

                int currDist = currCar.getTotalDist();
                currCar.setTotalDist(currDist + dist);


                carList.add(carIdx, currCar);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            cmd = scan.nextLine().split("\\s+");
        }

        carList.forEach(c -> {
            System.out.printf("%s %.2f %d%n", c.getModel(), c.getFuelAmount(), c.getTotalDist());
        });
        System.out.println();
    }

    private static int getIndexAndDelCar(Car car, List<Car> carList) {
        int idx = 0;
        for (int i = 0; i < carList.size(); i++) {
            Car c = carList.get(i);
            if (c.getModel().equals(car.getModel())) {
                idx = i;
                carList.remove(i);
            }
        }
        return idx;
    }

    private static Car getCurrentCar(String model, List<Car> carList) {
        Car result = null;
        for (Car c : carList) {
            if (c.getModel().equals(model)) {
                result = c;
            }
        }
        return result;

    }
}
