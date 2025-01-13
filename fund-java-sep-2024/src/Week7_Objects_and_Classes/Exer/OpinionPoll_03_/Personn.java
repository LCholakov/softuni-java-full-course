package Week7_Objects_and_Classes.Exer.OpinionPoll_03_;

public class Personn {
    String firstName;
    String lastName;
    int age;

    public Personn(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Personn(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
