package Week11_Exam_Prep.Wed;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, int[]> heroMap = new LinkedHashMap<>();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String[] s = scan.nextLine().split(" ");

            int[] hp_mp = {Integer.parseInt(s[1]), Integer.parseInt(s[2])};
            if (hp_mp[0] > 100) {
                hp_mp[0] = 100;
            }
            if (hp_mp[1] > 200) {
                hp_mp[1] = 200;
            }
            heroMap.put(s[0], hp_mp);
        }

        String[] cmd = scan.nextLine().split(" - ");
        while(!cmd[0].equals("End")) {
            String name = cmd[1];

            // Check for already dead hero?

            switch (cmd[0]) {
                case "CastSpell" -> {
                    int mp4spell = Integer.parseInt(cmd[2]);
                    String spell = cmd[3];
                    int heroMP = heroMap.get(name)[1];
                    // maybe should check for != null but whatever
                    if(heroMP >= mp4spell) {
                        heroMP -= mp4spell;
                        heroMap.get(name)[1] = heroMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spell, heroMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spell);
                    }

                }
                case "TakeDamage" -> {
                    int dmg = Integer.parseInt(cmd[2]);
                    String attacker = cmd[3];
                    heroMap.get(name)[0] = heroMap.get(name)[0] - dmg;
                    if (heroMap.get(name)[0] > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                            , name, dmg, attacker, heroMap.get(name)[0]);
                    } else {
                        heroMap.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                }
                case "Recharge" -> {
                    int amount = Integer.parseInt(cmd[2]);
                    if (heroMap.get(name)[1] + amount > 200) {
                        amount = 200 - heroMap.get(name)[1];
                        heroMap.get(name)[1] = 200;
                    } else {
                        heroMap.get(name)[1] = heroMap.get(name)[1] + amount;
                    }
                    System.out.printf("%s recharged for %d MP!%n", name, amount);
                }
                case "Heal" -> {
                    int amount = Integer.parseInt(cmd[2]);
                    if (heroMap.get(name)[0] + amount > 100) {
                        amount = 100 - heroMap.get(name)[0];
                        heroMap.get(name)[0] = 100;
                    } else {
                        heroMap.get(name)[0] = heroMap.get(name)[0] + amount;
                    }
                    System.out.printf("%s healed for %d HP!%n", name, amount);
                }
            }

            cmd = scan.nextLine().split(" - ");
        }

        for(Map.Entry<String, int[]> entry : heroMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("  HP: " + entry.getValue()[0]);
            System.out.println("  MP: " + entry.getValue()[1]);
        }
    }
}
