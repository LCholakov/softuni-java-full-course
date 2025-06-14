package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vehicle car = createVehicle(scan.nextLine().split(" "));
        Vehicle truck = createVehicle(scan.nextLine().split(" "));
        Vehicle bus = createVehicle(scan.nextLine().split(" "));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] tokens = scan.nextLine().split(" ");
            String cmd = tokens[0];
            String vehicleType = tokens[1];

            switch (cmd) {
                case "Drive" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                }
                case "DriveEmpty" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicles.get("Bus").driveEmpty(distance));
                }
                case "Refuel" -> {
                    double quantity = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(quantity);
                }
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car" -> vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck" -> vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus" -> vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        }
        return vehicle;
    }
}
