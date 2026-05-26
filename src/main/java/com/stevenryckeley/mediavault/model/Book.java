package main.java.com.stevenryckeley.mediavault.model;

public class Book extends Media {
    private String author;
    private int datePublished;

    public String getAuthor() {return author;}
    public int getDatePublished() {return datePublished;}

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public Book(String title, String author, char genre, int datePublished, int year) {
        super(title, author, year);
        this.datePublished = datePublished;
        this.genre = genre;
    }

    public String getSummary() {
        return String.format("%s by %s (%d) - Genre: %c", getTitle(), getAuthor(), getDatePublished(), genre);
    }

    public String getMediaType() {
        return "Book";
    }

    public boolean matches(String query) {
        query = query.toLowerCase();
        return title.toLowerCase().contains(query) || author.toLowerCase().contains(query) || String.valueOf(genre).toLowerCase().contains(query);
    }
}
