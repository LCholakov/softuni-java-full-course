//package ExamPrep.Hotel_03;
package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//Method add(Person person) - adds an entity to the roster if there is room for it
    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    //Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        boolean removeIsSuccessful = false;
        for(Person p : this.roster) {
            if (p.getName().equals(name)) {
                this.roster.remove(p);
                removeIsSuccessful = true;
                break;
            }
        }
        return removeIsSuccessful;
    }

//    Method getPerson(String name, String hometown) – returns the people with the given name and hometown or null if there is no such person.
    public Person getPerson(String name, String hometown) {
        for (Person p : this.roster) {
            if(p.getName().equals(name) && p.getHometown().equals(hometown)){
                return p;
            }
        }
        return null;
    }

//    Getter getCount() – returns the number of people.
    public int getCount() {
        return roster.size();
    }

//    getStatistics() – returns a String in the following format:
    public String getStatistics() {
//        "The people in the hotel {name} are:
//        {Person1}
//        {Person2}
//        (…)"

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));

        for (Person p : this.roster) {
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
