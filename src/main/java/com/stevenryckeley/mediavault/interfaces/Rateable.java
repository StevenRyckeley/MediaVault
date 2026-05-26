package main.java.com.stevenryckeley.mediavault.interfaces;

import main.java.com.stevenryckeley.mediavault.exceptions.InvalidRatingException;

public interface Rateable {
    void rate(int stars) throws InvalidRatingException;
    int getRating();
}
