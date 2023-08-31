package inheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Place {
    String getName();
    double getAverageStars();
    void updateAverageStars();

    void addReview(Review review);
}

class Restaurant implements Place {
    private final String name;
    private final int priceCategory;
    private final List<Review> reviews;

    public Restaurant(String name, int priceCategory) {
        this.name = name;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAverageStars() {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        return (double) totalStars / reviews.size();
    }

    @Override
    public void updateAverageStars() {
        // No need to manually update here as getAverageStars() recalculates the average on-the-fly
    }

    @Override
    public String toString() {
        return name + " | Stars: " + getAverageStars() + " | Price: " + "$".repeat(priceCategory);
    }

    public List<Review> getReviews() {
        return reviews;
    }
}

class Theater implements Place {
    private final String name;
    private final List<String> movies;
    private final List<Review> reviews;

    public Theater(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void removeMovie(String movie) {
        movies.remove(movie);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAverageStars() {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        return (double) totalStars / reviews.size();
    }

    @Override
    public void updateAverageStars() {
        // No need to manually update here as getAverageStars() recalculates the average on-the-fly
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Theater: ").append(name).append("\n");
        sb.append("Movies currently showing:\n");
        for (String movie : movies) {
            sb.append("- ").append(movie).append("\n");
        }
        sb.append("Average Stars: ").append(getAverageStars()).append("\n");
        return sb.toString();
    }
}

class Shop implements Place {
    private final String name;
    private final String description;
    private final int priceCategory;
    private final List<Review> reviews;

    public Shop(String name, String description, int priceCategory) {
        this.name = name;
        this.description = description;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAverageStars() {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        return (double) totalStars / reviews.size();
    }

    @Override
    public void updateAverageStars() {
        // No need to manually update here as getAverageStars() recalculates the average on-the-fly
    }

    @Override
    public String toString() {
        return name + " | Price: " + "$".repeat(priceCategory) + "\n" + description;
    }
}

class Review {
    private final Place place;
    private String movie;

    public Review(String body, User author, Place place) {
        this.place = place;
        this.movie = "";
        if (!author.hasReviewedPlace(place)) {
            author.addReview(this, place);
            place.addReview(this);
        }
    }

    public Review(String body, User author, Place place, String movie) {
        this(body, author, place);
        this.movie = movie;
    }

    public int getStars() {
        if (place == null) {
            return 0; // No place, no stars
        }
        return (int) Math.round(place.getAverageStars());
    }

    public void updateStars(int newStars) {
        if (newStars >= 0 && newStars <= 5) {
            int oldStars = getStars();
            if (place != null) {
                place.updateAverageStars();
                System.out.println("Updated stars for " + place.getName() + ": " + oldStars + " -> " + newStars);
            }
        } else {
            System.out.println("Stars should be between 0 and 5.");
        }
    }
}

class User {
    private final String username;
    private final Map<Place, Review> reviewedPlaces;

    public User(String username) {
        this.username = username;
        this.reviewedPlaces = new HashMap<>();
    }

    public boolean hasReviewedPlace(Place place) {
        return reviewedPlaces.containsKey(place);
    }

    public void addReview(Review review, Place place) {
        if (!reviewedPlaces.containsKey(place)) {
            reviewedPlaces.put(place, review);
        } else {
            System.out.println(username + " has already reviewed " + place.getName() + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        Restaurant restaurant = new Restaurant("Delicious Eats", 3);
        Theater theater = new Theater("Cineplex");
        Shop shop = new Shop("Fashion Paradise", "Trendy clothing for all ages.", 3);

        theater.addMovie("Avengers: Endgame");
        theater.addMovie("The Lion King");

        Review review1 = new Review("Great food!", user1, restaurant);
        Review review2 = new Review("Good movie experience!", user2, theater, "Avengers: Endgame");
        Review review3 = new Review("Fashionable clothing options.", user1, shop);

        user1.addReview(review1, restaurant);
        user2.addReview(review2, theater);
        user1.addReview(review3, shop);

        System.out.println(restaurant);
        System.out.println(theater);
        System.out.println(shop);

        review1.updateStars(5);
        review2.updateStars(4);

        System.out.println(restaurant);
    }
}
