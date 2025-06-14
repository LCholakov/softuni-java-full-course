package competition.entities.car;

import static competition.common.ExceptionMessages.CAR_MODEL_NULL_OR_EMPTY;

public abstract class BaseCar implements Car{
    private static final int DRIVE_BATTERY_DECREASE = 15;
    private static final int DRIVE_MILEAGE_INCREASE = 25;

    private String model;
    private int batteryCapacity;
    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        this.setModel(model);
        this.setBatteryCapacity(batteryCapacity);
        this.mileage = 0;
    }

    public String getModel() {
        return model;
    }

    // possible error: using isBlank instead of trim + empty
    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException(CAR_MODEL_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity < 0) {
            batteryCapacity = 0;
        }
        this.batteryCapacity = batteryCapacity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void drive() {
        this.setBatteryCapacity(this.batteryCapacity - DRIVE_BATTERY_DECREASE);
        this.setMileage(this.mileage += DRIVE_MILEAGE_INCREASE);
    }
}
