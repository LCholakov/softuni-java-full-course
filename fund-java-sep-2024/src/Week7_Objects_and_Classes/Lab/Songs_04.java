package Week7_Objects_and_Classes.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs_04 {
    private String listType;
    private String songName;
    private String songTime;
    public Songs_04(String listType, String songName, String songTime) {
        this.listType = listType;
        this.songName = songName;
        this.songTime = songTime;
    }

    public void setListType (String listType) { this.listType = listType; }
    public void setSongName (String songName) { this.songName = songName; }
    public void setSongTime (String songTime) { this.songTime = songTime; }

    public String getListType () { return this.listType; }
    public String getSongName () { return this.songName; }
    public String getSongTime () { return this.songTime; }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Songs_04> songList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("_");
//            Songs_04 temp = new Songs_04(input[0], input[1], input[2]);
            songList.add(new Songs_04(input[0], input[1], input[2]));
        }

        String typeToPrint = scan.nextLine();
        if(typeToPrint.equals("all")) {
            for (Songs_04 s : songList) {
                System.out.println(s.getSongName());
            }
        } else {
//            for (Songs_04 s : songList) {
//                if(s.getListType().equals(typeToPrint))
//                    System.out.println(s.getSongName());
//            }

            // same as above but using stream API
            List<Songs_04> filteredSongs = songList.stream()
                    .filter(e -> e.getListType().equals(typeToPrint))
                    .collect(Collectors.toList());
            for (Songs_04 s : filteredSongs) {
                System.out.println(s.getSongName());
            }
        }
    }
}
