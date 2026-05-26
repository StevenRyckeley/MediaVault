package main.java.com.stevenryckeley.mediavault.model;

public class Movie extends Media {
    private String director;
    private String mpaaRating; // G, PG, PG-13, R, NC-17
    private double length; // in hours

    
    public String getDirector() {return director;}
    public String getMpaaRating() {return mpaaRating;}
    public double getLength() {return length;}

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }
    
    public Movie(String title, String director, String mpaaRating, double length, int year, char genre) {
        super(title, director, year);
        this.mpaaRating = mpaaRating;
        this.length = length;
        this.genre = genre;
    }

    public String getSummary() {
        return String.format("%s (%d) - Directed by %s, Rated %s, %.1f hours, Genre: %c", getTitle(), getYear(), getDirector(), getMpaaRating(), getLength(), genre);
    }

    public String getMediaType() {
        return "Movie";
    }

    public boolean matches(String query) {
        query = query.toLowerCase();
        return title.toLowerCase().contains(query) || director.toLowerCase().contains(query) || String.valueOf(genre).toLowerCase().contains(query);
    }
}
