package Week7_Objects_and_Classes.Exer;

import java.util.*;

public class Students_04 {
    String firstName;
    String lastName;
    double grade;

    public Students_04(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return this.firstName.concat(" ").concat(lastName).concat(": ") + grade;
    }

    public static void main(String[] args) {
        ArrayList<Students_04> studList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String[] input = scan.nextLine().split(" ");
            studList.add(new Students_04(input[0], input[1], Double.parseDouble(input[2])));
        }
        // sort? can I sort the list using the grade as comparator?
        studList.sort(Comparator.comparing(Students_04::getGrade));
        Collections.reverse(studList);
        for (Students_04 stud : studList) {
            System.out.printf("%s %s: %.2f%n", stud.firstName, stud.lastName, stud.grade);

        }
    }
}
