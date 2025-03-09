package Week2_Interfaces_And_Abstraction.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
////        1. Define an Interface Person
//
//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if(Arrays.asList(citizenInterfaces).contains(Person.class)){
//            Method[] fields = Person.class.getDeclaredMethods();
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            Person person = new Citizen(name,age);
//            System.out.println(fields.length);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//        }

////        2. Multiple Implementation
//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
//                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
//            Method[] methods = Birthable.class.getDeclaredMethods();
//            Method[] methods1 = Identifiable.class.getDeclaredMethods();
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            String id = scanner.nextLine();
//            String birthDate = scanner.nextLine();
//            Identifiable identifiable = new Citizen(name,age,id,birthDate);
//            Birthable birthable = new Citizen(name,age,id,birthDate);
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            System.out.println(methods1.length);
//            System.out.println(methods1[0].getReturnType().getSimpleName());
//        }

//        3. Birthday Celebrations
        Scanner scan = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        String [] tokens = scan.nextLine().split("\\s+");
        loop: while (true) {
            switch (tokens[0]) {
                case "End": break loop;
                case "Citizen": citizens.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                break;
                case "Pet": pets.add(new Pet(tokens[1], tokens[2]));
                break;
                case "Robot": robots.add(new Robot(tokens[1], tokens[2]));
                break;
                }
            tokens = scan.nextLine().split("\\s+");
        }

        String searchYear = scan.nextLine();

        citizens.forEach(c -> {
            if (c.getBirthDate().split("/")[2].equals(searchYear)) {
                System.out.println(c.getBirthDate());
            }
        });

        pets.forEach(p -> {
            if (p.getBirthDate().split("/")[2].equals(searchYear)) {
                System.out.println(p.getBirthDate());
            }
        });
    }
}
