package Week7_Objects_and_Classes.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    public Students_05(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public void setFirstName (String firstName) { this.firstName = firstName; }
    public void setLastName (String lastName) { this.lastName = lastName; }
    public void setAge (int age) { this.age = age; }
    public void setCity (String city) { this.city = city; }

    public String getFirstName () { return this.firstName; }
    public String getLastName () { return this.lastName; }
    public int getAge () { return this.age; }
    public String getCity () { return this.city; }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Students_05> studentList = new ArrayList<>();

        String[] input = scan.nextLine().split(" ");
        while (!input[0].equals("end")) {
            String fName = input[0];
            String lName = input[1];
            int age = Integer.parseInt(input[2]);
            String city = input[3];

            Students_05 existingStudent = getStudent(studentList, fName, lName);
            if (existingStudent != null) {
                existingStudent.setAge(age);
                existingStudent.setCity(city);
            } else {
                Students_05 temp = new Students_05(fName, lName, age, city);
                studentList.add(temp);
            }

            input = scan.nextLine().split(" ");
        }

        String city = scan.nextLine();
        for (Students_05 s : studentList) {
            if (s.getCity().equals(city)) {
                System.out.printf("%s %s is %d years old%n", s.getFirstName(), s.getLastName(), s.getAge());
            }
        }
    }

    private static Students_05 getStudent (List < Students_05 > list, String fName, String lName){
        for (Students_05 s : list) {
            if (fName.equals(s.getFirstName()) && lName.equals(s.getLastName())) {
                return s;
            }
        }
        return null;
    }
}
