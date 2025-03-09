package Week2_Inheritance.NeedForSpeed;

public class Vehicle {
    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    double fuelConsumption;
    double fuel;
    int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void drive(double kilometers) {
        double consumedFuel = kilometers * this.fuelConsumption;
        if(consumedFuel <= this.getFuel()) {
            this.setFuel(this.getFuel() - consumedFuel);
        }
    }
}
