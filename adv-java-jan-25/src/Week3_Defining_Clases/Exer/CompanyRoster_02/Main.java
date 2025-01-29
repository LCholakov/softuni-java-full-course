package Week3_Defining_Clases.Exer.CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Employee>> empMap = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee emp = null;
            if (input.length == 6) {
                 emp = new Employee(name, salary, position, department, input[4], Integer.parseInt(input[5]));
            } else if (input.length == 4) {
                 emp = new Employee(name, salary, position, department);
            } else {
                if (input[4].contains("@")) {   // has email only
                    emp = new Employee(name, salary, position, department, input[4]);
                } else {        // has age only
                    emp = new Employee(name, salary, position, department, Integer.parseInt(input[4]));
                }
            }

            if (!empMap.containsKey(department)) {      // new department. Doesn't exist in map
                List<Employee> empList = new ArrayList<>();
                empList.add(emp);
                empMap.put(department, empList);
            } else {    // dep already exists
                empMap.get(department).add(emp);
            }
        }

        String highestSalDepartment = empMap.entrySet()
                    .stream()
                    .max(Comparator.comparingDouble(entry -> getAvgSalary(entry.getValue())))
                    .get()
                    .getKey();

        System.out.printf("Highest Average Salary: %s%n", highestSalDepartment);
        List<Employee> highestSalEmps = empMap.get(highestSalDepartment);
        highestSalEmps.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(highestSalEmps);

        highestSalEmps.forEach(System.out::println);
    }

    private static double getAvgSalary(List<Employee> list) {
        double sum = 0.0;
        for (Employee e : list) {
            sum += e.getSalary();
        }
        return sum / list.size();
    }
}
