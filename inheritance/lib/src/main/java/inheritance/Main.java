package inheritance;



public class Main {
    public static void main(String[] args) {
        try {
            Restaurant restaurant = new Restaurant("Sample Restaurant", 3);
            User user1 = new User("JohnDoe");
            User user2 = new User("JaneSmith");

            Review review1 = new Review("Great food and atmosphere!", user1, 4);
            Review review2 = new Review("Terrible service.", user2, 1);
            Review review3 = new Review("Awesome experience!", user1, 5);

            user1.addReview(review1);
            user2.addReview(review2);
            user1.addReview(review3);

            restaurant.addReview(review1);
            restaurant.addReview(review2);
            restaurant.addReview(review3);

            System.out.println(restaurant);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
