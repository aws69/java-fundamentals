package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private int priceCategory;
    private List<Review> reviews;

    public Restaurant(String name, int priceCategory) {
        this.name = name;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        if (!reviews.contains(review)) {
            reviews.add(review);
            review.setRestaurant(this);
        }
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }

        double totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        return totalStars / reviews.size();
    }

    public String toString() {
        return "Restaurant: " + name + "\n"
                + "Price Category: " + "$".repeat(priceCategory) + "\n"
                + "Average Rating: " + getAverageRating() + "\n"
                + "Reviews: \n" + reviewsToString();
    }

    private String reviewsToString() {
        StringBuilder sb = new StringBuilder();
        for (Review review : reviews) {
            sb.append(review);
            sb.append("\n");
        }
        return sb.toString();
    }
}
