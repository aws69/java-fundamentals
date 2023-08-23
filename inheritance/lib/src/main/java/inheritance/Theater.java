package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private List<String> movies;

    public Theater(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void removeMovie(String movie) {
        movies.remove(movie);
    }

    public String toString() {
        return "Theater: " + name + "\n"
                + "Movies: " + moviesToString();
    }

    private String moviesToString() {
        StringBuilder sb = new StringBuilder();
        for (String movie : movies) {
            sb.append(movie);
            sb.append(", ");
        }
        return sb.toString().isEmpty() ? "No movies currently showing" :
                sb.toString().substring(0, sb.length() - 2); // Remove trailing comma and space
    }
}
