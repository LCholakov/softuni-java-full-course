package Week2_Inheritance.Animals;

public class Kitten extends Cat{
    private static final String SOUND = "Meow";
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
