package main.java.com.stevenryckeley.mediavault.vault;

import main.java.com.stevenryckeley.mediavault.model.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Vault {
    private ArrayList<Media> items = new ArrayList<>();
    private static int totalEverAdded = 0;

    public synchronized void add(Media m) {
        items.add(m);
        totalEverAdded++;
    }

    public synchronized void remove(Media m) {
        items.remove(m);
    }

    public List<Media> search(String query) {
        List<Media> results = new ArrayList<>();
        for (Media item : items) {
            if (item.matches(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public Map<String, Long> getGenreCounts() {
        HashMap<String, Long> counts = new HashMap<>();
        for (Media item : items) {
            String genre = String.valueOf(item.getGenre());
            if (counts.containsKey(genre)) {
                long currentKey = counts.get(genre);
                counts.put(genre, currentKey + 1);
            }  else {
                counts.put(genre, 1L);
            }
        }
        return counts;
    }

    public static int getTotalEverAdded() {
        return totalEverAdded;
    }
}
