package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelToBeUsed = distance * fuelConsumption;
        if (fuelToBeUsed > fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        fuelQuantity -= fuelToBeUsed;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

        public void refuel(double quantity) {
        if (quantity >= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (fuelQuantity + quantity > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.setFuelQuantity(fuelQuantity += quantity);
        }
    }

    public String driveEmpty(double distance) {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
