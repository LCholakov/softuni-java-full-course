package Week12_Final_Exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> followersMap = new LinkedHashMap<String, Integer>();
        String delim = ":\\s";
        String[] cmd = scan.nextLine().split(delim);

        while (!cmd[0].equals("Log out")) {
            String username = cmd[1];
            switch (cmd[0]) {
                case "New follower" -> {
                    if(!followersMap.containsKey(username)) {
                        followersMap.put(username, 0);
                    }
                }
                case "Like" -> {
                    if(followersMap.containsKey(username)) {
                        followersMap.put(username, followersMap.get(username) + Integer.parseInt(cmd[2]));
                    } else {
                        followersMap.put(username, Integer.parseInt(cmd[2]));
                    }
                }
                case "Comment" -> {
                    if(followersMap.containsKey(username)) {
                        followersMap.put(username, followersMap.get(username) + 1);
                    } else {
                        followersMap.put(username, 1);
                    }
                }
                case "Blocked" -> {
                    if(followersMap.containsKey(username)) {
                        followersMap.remove(username);
                    } else {
                        System.out.println(username + " doesn't exist.");
                    }
                }
            }
            cmd = scan.nextLine().split(delim);
        }

        System.out.println(followersMap.size() + " followers");
        for(Map.Entry<String, Integer> e : followersMap.entrySet()) {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        }
    }
}
