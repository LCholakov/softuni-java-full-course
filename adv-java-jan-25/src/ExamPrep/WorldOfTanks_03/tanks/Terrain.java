package ExamPrep.WorldOfTanks_03.tanks;
//package tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        tanks = new ArrayList<>();
    }

    public String addTank(Tank tank) {
        Tank newT = tanks.stream()
                .filter(t -> (t.getBrand().equals(tank.getBrand()) && t.getModel().equals(tank.getModel())))
                .findFirst()
                .orElse(null);

        if (newT == null) {
            if(type.equals("Swamp") && tank.getWeight() > 14000) {
                return String.format("This %s is too heavy for this terrain!", tank.getBrand());
            } else {
                tanks.add(tank);
                return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
            }
        } else {
            return "Tank with this brand and model already exists!";
        }
    }

    public boolean removeTank(String brand, String model) {
        return tanks.removeIf(t -> (t.getBrand().equals(brand) && t.getModel().equals(model)));
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        String result = "";

        for (Tank t : tanks) {
            if (t.getBarrelCaliber() > barrelCaliber) {
                result = result + t.getBrand() + ", ";
            }
        }

        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
            return String.format("Tanks with caliber more than %dmm: %s", barrelCaliber, result);
        } else {
            return "There are no tanks with the specified caliber.";
        }
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        return tanks.stream()
                .filter(t -> (t.getBrand().equals(brand) && t.getModel().equals(model)))
                .findFirst()
                .orElse(null);
    }

    public String getTheMostArmoredTank() {
        Tank result = tanks.getFirst();

        for (Tank t : tanks) {
            if (t.getArmor() > result.getArmor()) {
                result = t;
            }
        }
        return String.format("%s %s is the most armored tank with %dmm. armor thickness."
                                    , result.getBrand(), result.getModel(), result.getArmor());
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {
        if (tanks.isEmpty()) {
            return String.format("There are no tanks in the %s.", type.toLowerCase());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tanks located in the %s:", type.toLowerCase())).append(System.lineSeparator());
        for (Tank t : tanks) {
            sb.append(String.format("-- %s %s%n", t.getBrand(), t.getModel()));
        }

        return sb.substring(0, sb.length() - 1);
    }
}
