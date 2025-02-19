package Exam;

import java.util.Scanner;

public class Pacman_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte matrSize = Byte.parseByte(scan.nextLine());
        byte pRow = -1;
        byte pCol = -1;

        byte starCount = 0;
        byte pHealth = 100;
        boolean isFrozen = false;
        char[][] matr = new char[matrSize][matrSize];
        for (byte i = 0; i < matrSize; i++) {
            String s = scan.nextLine();
            matr[i] = s.toCharArray();
            for (byte j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '*') {
                    starCount ++;
                } else if(s.charAt(j) == 'P') {
                    pRow = i;
                    pCol = j;
                    matr[i][j] = '-';
                }
            }
        }

        String cmd = scan.nextLine();
        while (starCount > 0 && pHealth > 0 && !cmd.equals("END")) {
            byte pTempRow = pRow;
            byte pTempCol = pCol;
            // I should really start using funcs. This is waaaaay too long

            // move player
            switch(cmd) {
                case "up" -> {
                    if(pTempRow == 0) { pTempRow = (byte) (matrSize - 1); }
                    else { pTempRow--; }
                }
                case "down" -> {
                    if(pTempRow == matrSize - 1) { pTempRow = 0; }
                    else { pTempRow++; }
                }
                case "left" -> {
                    if(pCol == 0) {  pTempCol = (byte) (matrSize - 1); }
                    else { pTempCol--; }
                }
                case "right" -> {
                    if(pTempCol == matrSize - 1) { pTempCol = 0; }
                    else { pTempCol++; }
                }
            }

            // check what's on new location
            char c = matr[pTempRow][pTempCol];
            if (c == '*') {
                matr[pTempRow][pTempCol] = '-';
                starCount--;
            } else if (c == 'G') {
                if (isFrozen) {
                    isFrozen = false;
                } else {
                    pHealth -= 50;
                }
                matr[pTempRow][pTempCol] = '-';
            } else if (c == 'F') {
                matr[pTempRow][pTempCol] = '-';
                isFrozen = true;
            }

            pRow = pTempRow;
            pCol = pTempCol;
            cmd = scan.nextLine();
        }
        matr[pRow][pCol] = 'P';

        if (pHealth > 0) {
            if (starCount > 0) {
                System.out.println("Pacman failed to collect all the stars.");
            } else {
                System.out.println("Pacman wins! All the stars are collected.");
            }
        } else {
            System.out.printf("Game over! Pacman last coordinates [%d,%d]%n", pRow, pCol);
        }

        System.out.println("Health: " + pHealth);
        if (starCount > 0) { System.out.println("Uncollected stars: " + starCount); }

        for (char[] cArr : matr) {
            System.out.println(cArr);
        }
    }
}
