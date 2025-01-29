package Week3_Defining_Clases.Exer.SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsFor1km;
    private int totalDist;

    public Car(String model, double fuelAmount, double fuelCostFor1km, int totalDist) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsFor1km = fuelCostFor1km;
        this.totalDist = totalDist;
    }

    public String getModel() {
        return model;
    }

    public boolean canCoverDist(int distance) {
        double necessaryFuel = fuelConsFor1km * distance;
        return necessaryFuel <= fuelAmount;
    }

    public double getRemainingFuel(int distance) {
        return fuelAmount - (fuelConsFor1km * distance);
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsFor1km() {
        return fuelConsFor1km;
    }

    public void setTotalDist(int totalDist) {
        this.totalDist = totalDist;
    }

    public int getTotalDist() {
        return totalDist;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
