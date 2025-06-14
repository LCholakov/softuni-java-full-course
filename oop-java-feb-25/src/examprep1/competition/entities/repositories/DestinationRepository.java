package competition.entities.repositories;

import competition.entities.destination.Destination;

import java.util.*;

public class DestinationRepository implements Repository<Destination>{
    private Collection<Destination> destinations;

    public DestinationRepository() {
//        TODO: if tests fail, try LinkedList
        this.destinations = new LinkedList<>();
    }

    @Override
    public Collection<Destination> getCollection() {
        return Collections.unmodifiableCollection(destinations);
    }

    @Override
    public void add(Destination destination) {
        this.destinations.add(destination);
    }

    @Override
    public boolean remove(Destination destination) {
        return this.destinations.remove(destination);
    }

    @Override
    public Destination byName(String name) {
        return this.destinations.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
