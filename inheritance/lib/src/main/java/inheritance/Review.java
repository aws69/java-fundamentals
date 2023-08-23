package inheritance;

public class Review {
    private String body;
    private User user;
    private Restaurant restaurant;
    private Shop shop;
    private String movie;
    private int stars;

    public Review(String body, User user, int stars, String movie) {
        this.body = body;
        this.user = user;
        if (stars >= 0 && stars <= 5) {
            this.stars = stars;
        } else {
            throw new IllegalArgumentException("Stars must be between 0 and 5");
        }
        this.movie = movie;
    }
    public void updateStars(int newStars) {
        if (newStars >= 0 && newStars <= 5) {
            int oldStars = stars;
            stars = newStars;

            if (restaurant != null) {
                restaurant.updateAverageRating(oldStars, newStars);
            }

            if (shop != null) {
                shop.updateAverageRating(oldStars, newStars);
            }
        } else {
            throw new IllegalArgumentException("Stars must be between 0 and 5");
        }
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getPlaceName() {
        if (restaurant != null) {
            return restaurant.getName();
        } else if (shop != null) {
            return shop.getName();
        } else {
            return "Unknown Place";
        }
    }

    public String getReviewerUsername() {
        return user.getUsername();
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getStars() {
        return stars;
    }

    public String toString() {
        return "Review by " + getReviewerUsername() + "\n"
                + "Stars: " + stars + "\n"
                + "Place: " + getPlaceName() + "\n"
                + "Movie: " + (movie != null ? movie : "N/A") + "\n"
                + "Body: " + body;
    }


}
