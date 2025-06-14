//package Exam.MajesticShips_03;
package ships;

import java.util.ArrayList;
import java.util.List;

public class Harbor {
    private String location;
    private int minDepth;
    private List<Ship>  ships;

    public Harbor(String location, int minDepth) {
        this.location = location;
        this.minDepth = minDepth;
        ships = new ArrayList<>();
    }

    public String addShip(Ship ship) {
        if (ships.contains(ship)) {
            return "Ship with this name already exists!";
        } else if (ship.getDraft() > minDepth) {
            return String.format("The ship %s cannot dock due to draft limitations!", ship.getName());
        }
        ships.add(ship);
        return String.format("Ship %s added to the harbor.", ship.getName());
    }

    public boolean removeShip(String name) {
        return ships.removeIf(sh -> (sh.getName().equals(name)));
    }

    public String getShipsByType(String type) {
        StringBuilder result = new StringBuilder();

        for (Ship sh : ships) {
            if (sh.getType().equals(type)) {
                result.append(sh.getName()).append(", ");
            }
        }

        if (result.isEmpty()) {
            return "There are no ships of the requested type.";
        } else {
            // remove last 2 chars to remove comma. Ugly but gotta move on
            return String.format("Ships of type %s: %s", type, result.substring(0, result.length() - 2));
        }
    }

    public Ship getShipByName(String name) {
        return ships.stream()
                .filter(sh -> (sh.getName().equals(name)))
                .findFirst()
                .orElse(null);
    }

    public String getLargestShip() {
        if (ships.isEmpty()) { return "No ships in the harbor."; }
        int maxTonnage = 0;
        Ship result = null;
        for (Ship sh : ships) {
            if (sh.getTonnage() > maxTonnage) {
                maxTonnage = sh.getTonnage();
                result = sh;
            }
        }
        return String.format("%s is the largest ship with a tonnage of %d tons."
                            , result.getName(), result.getTonnage());
    }

    public int getCount(){
        return ships.size();
    }

    public String getStatistics() {
        if (ships.isEmpty()) { return String.format("No ships docked in %s.", location); }

        StringBuilder result = new StringBuilder();
        result.append(String.format("Ships docked in %s:", location)).append(System.lineSeparator());
        for (Ship sh : ships) {
            result.append("* ").append(sh.getName()).append(System.lineSeparator());
        }

        return result.toString();
    }

}
