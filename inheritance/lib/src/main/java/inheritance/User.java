package inheritance;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Review> reviews;

    public User(String username) {
        this.username = username;
        this.reviews = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }
    public void addReview(Review review) {
        if (!reviews.contains(review)) {
            reviews.add(review);
            review.setUser(this);
        }
    }

    public String toString() {
        return "User: " + username;
    }


}
