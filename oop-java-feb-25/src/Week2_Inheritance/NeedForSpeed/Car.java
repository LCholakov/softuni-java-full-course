package Week2_Inheritance.NeedForSpeed;

public class Car extends Vehicle{
    final static double DEFAULT_FUEL_CONSUMPTION = 3;
    public Car(double fuelConsumption, int horsePower) {
        super(fuelConsumption, horsePower);
        super.setFuelConsumption(this.DEFAULT_FUEL_CONSUMPTION);
    }
}
