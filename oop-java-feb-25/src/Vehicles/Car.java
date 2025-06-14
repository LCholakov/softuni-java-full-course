package Vehicles;

public class Car extends Vehicle{
    private static final double AC_CONSUMPTION_ADDITION = 0.9;
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = fuelConsumption + AC_CONSUMPTION_ADDITION;
    }
}
