package inheritance;

public class Review {
    private String body;
    private User user;
    private Restaurant restaurant;
    private int stars;

    public Review(String body, User user, int stars) {
        this.body = body;
        this.user = user;
        if (stars >= 0 && stars <= 5) {
            this.stars = stars;
        } else {
            throw new IllegalArgumentException("Stars must be between 0 and 5");
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStars() {
        return stars;
    }

    public String toString() {
        return "Review by " + user + "\n"
                + "Stars: " + stars + "\n"
                + "Body: " + body;
    }

    public void setRestaurant(Restaurant restaurant) {
    }
}
