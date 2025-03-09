
package Week1_Working_With_Abstraction.GreedyTimes_06;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> itemsMap
                = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
//        int goldTotal = 0;
//        int gemTotal = 0;
//        int cashTotal = 0;

        // TODO: make a class to hold the inner map
        int bagCapacity = Integer.parseInt(scanner.nextLine());
        String[] itemInput = scanner.nextLine().split("\\s+");

        for (int i = 0; i < itemInput.length; i += 2) {
            String itemName = itemInput[i];
            int itemQty = Integer.parseInt(itemInput[i + 1]);

            String itemType = getItemType(itemName);

            if (itemType.isEmpty() || !isEnoughCapacity(bagCapacity, itemsMap, itemQty)) {
                continue;
            }

            // TODO: understand what does this do
            switch (itemType) {
                case "Gem":
                    if (!itemsMap.containsKey(itemType)) {
                        if (itemsMap.containsKey("Gold")) {
                            if (itemQty > sumQtyForType(itemsMap, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (sumQtyForType(itemsMap, itemType) + itemQty > sumQtyForType(itemsMap, "Gold")) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!itemsMap.containsKey(itemType)) {
                        if (itemsMap.containsKey("Gem")) {
                            if (itemQty > sumQtyForType(itemsMap, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (sumQtyForType(itemsMap, itemType) + itemQty > sumQtyForType(itemsMap, "Gem")) {
                        continue;
                    }
                    break;
            }

            // Create subitem map if item type doesn't exist
            if (!itemsMap.containsKey(itemType)) {
                itemsMap.put((itemType), new LinkedHashMap<String, Long>());
            }
            // add item to the subitem map if item doesn't exist
            if (!itemsMap.get(itemType).containsKey(itemName)) {
                itemsMap.get(itemType).put(itemName, 0L);
            }

            itemsMap.get(itemType)
                    .put(itemName, itemsMap.get(itemType).get(itemName) + itemQty);

//            if (itemType.equals("Gold")) {
//                goldTotal += itemQty;
//            } else if (itemName.equals("Gem")) {
//                gemTotal += itemQty;
//            } else if (itemName.equals("Cash")) {
//                cashTotal += itemQty;
//            }
        }

        printResult(itemsMap);
    }

    private static long sumQtyForType(Map<String, LinkedHashMap<String, Long>> itemsMap, String gold) {
       return itemsMap.get("Gold").values()
                .stream().mapToLong(e -> e).sum();
    }

    private static void printResult(Map<String, LinkedHashMap<String, Long>> itemsMap) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> e : itemsMap.entrySet()) {
            Long sumValues = e.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", e.getKey(), sumValues);

            e.getValue().entrySet().stream()
                    .sorted((e1, e2)
                            -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static boolean isEnoughCapacity(int bagCapacity, Map<String, LinkedHashMap<String, Long>> itemsMap, int itemQty) {
        return bagCapacity > itemsMap.values()
                .stream().map(Map::values).flatMap(Collection::stream)
                .mapToLong(e -> e).sum() + itemQty;
    }

    private static String getItemType(String itemName) {
        if (itemName.length() == 3) {
            return "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (itemName.equalsIgnoreCase("gold")) {
            return "Gold";
        } else {
            return "";
        }
    }
}