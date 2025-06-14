package Vehicles;

public class Truck extends Vehicle{
    private static final double AC_CONSUMPTION_ADDITION = 1.6;
    private static final double FUEL_PERCENTAGE_AFTER_LEAK = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = fuelConsumption + AC_CONSUMPTION_ADDITION;
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * FUEL_PERCENTAGE_AFTER_LEAK);
    }
}
