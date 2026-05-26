package main.java.com.stevenryckeley.mediavault.model;

public class Album extends Media {
    private String artist;
    private int numberOfSongs;

    public String getArtist() {return artist;}
    public int getNumberOfSongs() {return numberOfSongs;}

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }
    
    public Album(String title, String artist, char genre, int numberOfSongs, int yearReleased) {
        super(title, artist, yearReleased);
        this.artist = artist;
        this.genre = genre;
        this.numberOfSongs = numberOfSongs;
    }

    public String getSummary() {
        return String.format("%s by %s - Genre: %c, %d songs", title, artist, genre, numberOfSongs);
    }

    public String getMediaType() {
        return "Album";
    }

    public boolean matches(String query) {
        query = query.toLowerCase();
        return title.toLowerCase().contains(query) || artist.toLowerCase().contains(query) || String.valueOf(genre).toLowerCase().contains(query);
    }
}
