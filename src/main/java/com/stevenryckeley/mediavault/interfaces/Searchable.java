package main.java.com.stevenryckeley.mediavault.interfaces;

public interface Searchable {
    boolean matches (String query); // case-insensitive match on title, creator, genre
}
