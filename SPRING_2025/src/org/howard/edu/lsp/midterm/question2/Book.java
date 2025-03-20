package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in the library.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor to initialize a Book object.
     * Reference: https://stackoverflow.com/questions/78133631/java-getter-and-setters-for-simple-properties-best-practice
     * @param title         title of book
     * @param author        author of book
     * @param ISBN           ISBN number of book
     * @param yearPublished  year book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * The Equals method is Overridden and compares two Book. 
     *
     * @param obj  object to compare.
     * @return true if books are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return ISBN.equals(other.ISBN) && author.equals(other.author);
    }

    /**
     * Returns a string the Book.
     *
     * @return Book's details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
