package competition.entities.destination;

import competition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import static competition.common.ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY;
import static competition.common.ExceptionMessages.NEGATIVE_DISTANCE_VALUE;

public abstract class BaseDestination implements  Destination {
    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        this.setName(name);
        this.setDistance(distance);
        this.cars = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    // possible error: using isBlank instead of trim + empty
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getDistance() {

        return distance;
    }

    public void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }
}
