package Week2_Inheritance.Animals;

public class Animal {
    private static final String INVALID_INPUT = "Invalid input!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.getClass().getSimpleName().toString()).append(System.lineSeparator());
//        sb.append(String.format("%s %d %s%n", this.name, this.age, this.gender));
//        sb.append(this.produceSound()).append(System.lineSeparator());
        return this.getClass().getSimpleName().toString() + "\n" +
                this.getName() + " " +
                this.getAge() + " " +
                this. getGender() + "\n" +
                this.produceSound();
    }
}


//Cat
//Tom 12 Male
//Meow meow