package Week7_Objects_and_Classes.Exer;

import java.util.Scanner;

public class Articles_02 {
    String title;
    String content;
    String author;

    public Articles_02 (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void editContent (String content) {
        this.content = content;
    }
    public void editAuthor (String author) {
        this.author = author;
    }
    public void editTitle (String title) {
        this.title = title;
    }

    public String toString () {
        return this.title + " - " + this.content + ": " + this.author;
    }
    // add rename
    // add toString;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        Articles_02 article = new Articles_02(input[0], input[1], input[2]);

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String[] cmd = scan.nextLine().split(": ");
            switch (cmd[0]) {
                case "Edit" -> article.editContent(cmd[1]);
                case "ChangeAuthor" -> article.editAuthor(cmd[1]);
                case "Rename" -> article.editTitle(cmd[1]);
            }
        }
        System.out.println(article.toString());
    }
}
