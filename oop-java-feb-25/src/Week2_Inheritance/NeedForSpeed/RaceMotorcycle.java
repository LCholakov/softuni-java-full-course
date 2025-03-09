package Week2_Inheritance.NeedForSpeed;

public class RaceMotorcycle extends  Motorcycle{
    final static double DEFAULT_FUEL_CONSUMPTION = 8;
    public RaceMotorcycle(double fuelConsumption, int horsePower) {
        super(fuelConsumption, horsePower);
        super.setFuelConsumption(this.DEFAULT_FUEL_CONSUMPTION );
    }
}
