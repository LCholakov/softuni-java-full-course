package Vehicles;

public class Bus extends Vehicle{
    private static final double AC_CONSUMPTION_ADDITION = 1.4;

//    private double emptyBusFuelConsumption;
//    private double fullBusFuelConsumption;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
//        emptyBusFuelConsumption = fuelConsumption;
//        fullBusFuelConsumption = fuelConsumption + AC_CONSUMPTION_ADDITION;
    }

    @Override
    public String drive(double distance) {
        this.setFuelConsumption(this.fuelConsumption + AC_CONSUMPTION_ADDITION);
        return super.drive(distance);
    }

    public String driveEmpty(double distance) {
        return super.drive(distance);
    }
}
