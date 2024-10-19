package Week6_Mid_Exam.Exam;

import java.util.*;
import java.util.stream.Collectors;

public class MusicPlaylist_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> strList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        byte n = Byte.parseByte(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
                case "Add" -> addSong(strList, input[3]);
                case "Delete" -> deleteSongs(strList, Integer.parseInt(input[3]));
                case "Shuffle" -> shuffleSongs(strList, Integer.parseInt(input[3]), Integer.parseInt(input[5]));
                case "Insert" -> insertSong(strList, input[2], Integer.parseInt(input[4]));
                case "Sort" -> sortSongs(strList);
                case "Play" -> playSongs(strList);
            }
        }
    }

    private static void addSong(List<String> strList, String song) {
        if (!strList.contains(song)) {
            strList.add(song);
            System.out.println(song + " successfully added");
        }
    }

    private static void deleteSongs(List<String> list, int n) {
        if (n > list.size()) return;
        List<String> deletedSongs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            deletedSongs.add(list.get(0));
            list.remove(0);
        }
        System.out.println(deletedSongs.toString().replaceAll("[\\[\\]]", "") + " deleted");
    }

    private static void shuffleSongs(List<String> list, int idx1, int idx2) {
        if (idx1 < 0 || idx1 >= list.size()) return;
        if (idx2 < 0 || idx2 >= list.size()) return;

        String tempSong = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, tempSong);
        // not sure if this is supposed to be in order smallest index first, higher index second
        System.out.println(list.get(idx1) + " is swapped with " + list.get(idx2));
    }

    private static void insertSong(List<String> list, String song, int idx) {
        if (idx < 0 || idx > list.size()) {
            System.out.println("Index out of range");
        } else if (list.contains(song)) {
            System.out.println("Song is already in the playlist");
        } else {
            list.add(idx, song);
            System.out.println(song + " successfully inserted");
        }
    }

    private static void sortSongs(List<String> list) {
        Collections.sort(list);
        Collections.reverse(list);
    }

    private static void playSongs(List<String> list) {
        System.out.println("Songs to Play:");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
