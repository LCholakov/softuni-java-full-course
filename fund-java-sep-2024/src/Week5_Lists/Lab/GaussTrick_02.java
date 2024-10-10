    package Week5_Lists.Lab;

    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class GaussTrick_02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> numList = Arrays
                                            .stream(scanner.nextLine().split(" "))
                                            .map(Integer::parseInt).collect(Collectors.toList());

            for (int i = 0; i <= numList.size() / 2; i++) {
                int result = 0;

                if (i != numList.size() / 2) {
                    System.out.print((numList.get(i) + i + numList.get(numList.size() - 1 - i) - i) + " ");
                } else if (numList.size() % 2 != 0){
                    System.out.print(numList.get(i));
                }
            }

            // more elegant solution from lecture ppt
//            for (int i = 0; i <= numList.size() / 2; i++) {
//                numList.set(i, numList.get(i) + numList.get(numList.size() - 1));
//                numList.remove(numList.size() - 1);
//            }
        }
    }
