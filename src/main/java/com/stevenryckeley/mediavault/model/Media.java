package main.java.com.stevenryckeley.mediavault.model;

import java.io.Serializable;
import main.java.com.stevenryckeley.mediavault.interfaces.Rateable;
import main.java.com.stevenryckeley.mediavault.interfaces.Searchable;


public abstract class Media implements Serializable, Rateable, Searchable {
    protected String title;
    protected String creator; // director / author / artist
    protected int year;
    protected int rating; // 0-5
    protected boolean consumed; // watched / read / listened
    protected char genre;

    public String getTitle() {return title;}
    public int getRating() {return rating;}
    public boolean isConsumed() {return consumed;}
    public int getYear() {return year;}
    public char getGenre() {return genre;}

    public Media (String title, String creator, int year) {
        this.title = title;
        this.creator = creator;
        this.year = year;
    }

    public abstract String getSummary();
    public abstract String getMediaType();
    public abstract boolean matches(String query);

    public String getDisplayTitle() {
        return (rating >= 4) ? "★ " + title : title;
    }

    public void rate(int stars) {
        if (stars < 0 || stars > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5 stars"); // Fix this with custom exception later
        }
        this.rating = stars;
    }
}
