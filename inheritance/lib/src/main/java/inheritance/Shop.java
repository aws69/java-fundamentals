package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private String description;
    private int priceCategory;
    private List<Review> reviews;
    private double averageRating;

    public Shop(String name, String description, int priceCategory) {
        this.name = name;
        this.description = description;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        if (!reviews.contains(review)) {
            reviews.add(review);
            review.setShop(this);
        }
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }

        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }

        return (double) totalStars / reviews.size();
    }
    public void updateAverageRating(int oldStars, int newStars) {
        int totalStars = (int) (getAverageRating() * reviews.size());
        totalStars = totalStars - oldStars + newStars;
        double newAverage = (double) totalStars / reviews.size();
        setAverageRating(newAverage);
    }

    public String getName() {
        return name;
    }

    private void setAverageRating(double average) {
        this.averageRating = average;
    }

    public String toString() {
        return "Shop: " + name + "\n"
                + "Description: " + description + "\n"
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
