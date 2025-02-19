package Week4_IteratorsAndComparators.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String...authors) {
        this.title = title;
        this.year = year;
//        this.authors = new ArrayList<>();
//        for (String auth : authors) {
//            this.authors.add(auth);
//        }
//        if (authors.length == 0) {
//            this.authors = new ArrayList<>();
//        } else {
//            this.authors = new ArrayList<>(Arrays.asList(authors));
//        }
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        if (authors.length > 0) {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String toString () {
        return String.format("%s (%s)", this.title, this.year);
    }

    @Override
    public int compareTo(Book book) {
        if (this.title.equals(book.getTitle())) {
            return Integer.compare(this.year, book.getYear());
        } else {
            return this.title.compareTo(book.getTitle());
        }
    }
}
