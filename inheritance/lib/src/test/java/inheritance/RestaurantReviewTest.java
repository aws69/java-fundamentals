package inheritance;

public class RestaurantReviewTest {
    public static void main(String[] args) {
        testRestaurantAndReviewFunctionality();
        testUserReviewRestriction();
    }

    private static void testRestaurantAndReviewFunctionality() {
        try {
            Restaurant restaurant = new Restaurant("Sample Restaurant", 3);
            User user1 = new User("AwsAlomari");
            User user2 = new User("EtharAlomari");

            Review review1 = new Review("Great food and atmosphere!", user1, 4);
            Review review2 = new Review("Terrible service.", user2, 1);
            Review review3 = new Review("Awesome experience!", user1, 5);

            user1.addReview(review1);
            user2.addReview(review2);
            user1.addReview(review3);

            restaurant.addReview(review1);
            restaurant.addReview(review2);
            restaurant.addReview(review3);

            System.out.println("Restaurant and Review Functionality Test:");
            System.out.println(restaurant);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testUserReviewRestriction() {
        try {
            Restaurant restaurant = new Restaurant("Another Restaurant", 2);
            User user1 = new User("Emad");
            User user2 = new User("Ayoub");

            Review review1 = new Review("Good food!", user1, 3);
            Review review2 = new Review("Average experience.", user2, 2);

            user1.addReview(review1);
            restaurant.addReview(review1);

            user2.addReview(review2); // This should not add the review
            restaurant.addReview(review2); // This should not add the review

            System.out.println("User Review Restriction Test:");
            System.out.println(restaurant);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}
