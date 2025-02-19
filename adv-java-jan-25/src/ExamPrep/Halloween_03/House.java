//package ExamPrep.Halloween_03;
//package halloween;
import java.util.ArrayList;
import java.util.List;

//package halloween;
public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.capacity > data.size()) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        for (Kid kid : this.data) {
            if (kid.getName().equals(name)) {
                this.data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public Kid getKid(String street) {
        for (Kid kid : this.data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:").append(System.lineSeparator());

        for (Kid kid : this.data) {
            sb.append(String.format("%s from %s street", kid.getName(), kid.getStreet())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
