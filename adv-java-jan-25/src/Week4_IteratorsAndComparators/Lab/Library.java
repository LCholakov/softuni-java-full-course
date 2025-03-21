package Week4_IteratorsAndComparators.Lab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
//        return new Iterator<Book>() {
//            int index = 0;
//            @Override
//            public boolean hasNext() {
//                return index < books.length;
//            }
//
//            @Override
//            public Book next() {
//                return books[index++];
//            }
//        };
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }
}
