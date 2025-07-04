package competition.entities.competition;

import competition.entities.car.Car;
import competition.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition{
    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        for(Car car : destination.getCars()) {
            while (car.getMileage() < destination.getDistance()) {
//                lecture uses
//                if(car.getBatteryCapacity() < 15 || car.getBatteryCapacity() <= 0)
                if(car.getBatteryCapacity() < 15) {
                    break;
                }
                car.drive();
            }
        }
    }
}
