package Week2_Inheritance.NeedForSpeed;

public class SportCar extends Car{
    final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuelConsumption, int horsePower) {
        super(fuelConsumption, horsePower);
        super.setFuelConsumption(this.DEFAULT_FUEL_CONSUMPTION);
    }
}
