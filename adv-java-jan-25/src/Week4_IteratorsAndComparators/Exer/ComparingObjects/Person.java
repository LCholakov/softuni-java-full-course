package Week4_IteratorsAndComparators.Exer.ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
//        int compareName = this.name.compareTo(o.name);
//        int compareAge = this.age.compareTo(o.age);
//        int compareTown = this.town.compareTo(o.town);
//
//        if (compareName != 0) {
//            return compareName;
//        } else if (compareAge != 0) {
//            return compareAge;
//        } else if (compareTown != 0) {
//            return compareTown;
//        }
//
//        return 0;
        if (this.name.compareTo(o.name) == 0
        && this.age.compareTo(o.age) == 0
        && this.town.compareTo(o.town) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
