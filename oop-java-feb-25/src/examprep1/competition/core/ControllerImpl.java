package competition.core;

//TODO - Implement all the methods

import competition.entities.car.*;
import competition.entities.competition.Competition;
import competition.entities.competition.CompetitionImpl;
import competition.entities.destination.*;
import competition.entities.repositories.DestinationRepository;
import competition.entities.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static competition.common.ConstantMessages.*;
import static competition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Destination> destinationRepository;

    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
    }

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination dest;
        switch (destinationType) {
            case "Lake":
                dest = new Lake(destinationName);
                break;
            case "Mountain":
                dest = new Mountain(destinationName);
                break;
            case "SeaSide":
                dest = new SeaSide(destinationName);
                break;
            default:
                throw new IllegalArgumentException(INVALID_DESTINATION);
        }
        if (this.destinationRepository.byName(destinationName) != null) {
//        if (this.destinationRepository.getCollection().contains(dest)) {
            throw new IllegalArgumentException(EXISTING_DESTINATION);
        }
        destinationRepository.add(dest);
        return String.format(DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        Destination dest = destinationRepository.byName(destinationName);
        if(dest == null) {
            throw new NullPointerException(NON_EXISTING_DESTINATION);
        }
        Car car = dest.getCars()
                .stream()
                .filter(c -> c.getModel().equals(carModel))
                .findFirst().orElse(null);

        if(car != null) {
            throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL);
        }

        switch (carBrand) {
            case "Tesla": car = new Tesla(carModel);
                break;
            case "Hyundai": car = new Hyundai(carModel);
                break;
            case "VW": car = new VW(carModel);
                break;
            case "Dacia": car = new Dacia(carModel);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAR);
        }

        dest.getCars().add(car);
        return String.format(CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        Destination dest = destinationRepository.byName(destinationName);
        Collection<Car> cars = dest.getCars();

        Competition competition = new CompetitionImpl();
        competition.startVoyage(dest, cars);

        long droppedCarCount =  dest.getCars()
                .stream()
                .filter(c ->
                        (c.getMileage() < dest.getDistance() && c.getBatteryCapacity() <= 0)
                        || (c.getMileage() < dest.getDistance() && c.getBatteryCapacity() < 15) )
                .count();


        return String.format(VOYAGE_OVER, destinationName, droppedCarCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        Collection<Destination> dests = this.destinationRepository.getCollection();
        dests.forEach(d -> {
            sb.append(String.format(CARS_TOOK_PART, d.getName())).append(System.lineSeparator());
            d.getCars().forEach(c -> {
                sb.append(String.format(FINAL_CAR_INFO,
                        c.getClass().getSimpleName(),
                        c.getModel(),
                        c.getBatteryCapacity(),
                        c.getMileage()
                )).append(System.lineSeparator());

            });
        });

        return sb.toString();
    }
}
