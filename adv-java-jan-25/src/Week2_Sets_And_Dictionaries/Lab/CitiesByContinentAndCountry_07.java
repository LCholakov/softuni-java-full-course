package Week2_Sets_And_Dictionaries.Lab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, List<String>>> contMap = new LinkedHashMap<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0 ; i--) {
            String [] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (contMap.containsKey(continent)) {
                if(contMap.get(continent).containsKey(country)) {
                    contMap.get(continent).get(country).add(city);
                } else {
//                    List<String> tempList = new ArrayList<>();
//                    tempList.add(city);
//                    Map<String, List<String>> tempMap = new LinkedHashMap<>();
//                    tempMap.put(country, tempList);
//                    contMap.get(continent).put(country, List.of(city));
                    contMap.get(continent).put(country, new ArrayList<>() {
                        { add(city); }
                    });
                }
            } else {
//                contMap.put(continent, Map.of(country, List.of(city)));
                contMap.put(continent, new LinkedHashMap<>() {
                    { put(country, new ArrayList<>() {
                        { add(city); }
                    });}
                });
            }
        }
//System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
        contMap.forEach((conti, ctry) -> {
            System.out.println(conti + ":");
            ctry.forEach((ctryName, cityList) -> {
                System.out.print("  " + ctryName + " -> ");
                System.out.println(cityList.toString().replaceAll("[\\[\\]]", ""));
//                cityList.forEach(c -> System.out.print(c + ", "));
//                System.out.println();
            });
        });
    }
}
