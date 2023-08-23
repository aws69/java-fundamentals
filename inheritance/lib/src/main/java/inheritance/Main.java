package inheritance;

public class Main {
    public static void main(String[] args) {
        testRestaurantAndReviewFunctionality();
        testShopAndReviewFunctionality();
        testTheaterFunctionality();
    }

    private static void testRestaurantAndReviewFunctionality() {
        try {
            Restaurant restaurant = new Restaurant("Sample Restaurant", 3);
            User user1 = new User("Aws");
            User user2 = new User("Ethar");

            Review review1 = new Review("Great food and atmosphere!", user1, 4, null);
            Review review2 = new Review("Terrible service.", user2, 1, null);
            Review review3 = new Review("Awesome experience!", user1, 5, null);

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

    private static void testShopAndReviewFunctionality() {
        try {
            Shop shop = new Shop("Fashion Boutique", "Trendy clothes and accessories", 2);
            User user1 = new User("Emad");
            User user2 = new User("Kholod");

            Review review1 = new Review("Great collection!", user1, 4, null);
            Review review2 = new Review("Average experience.", user2, 3, null);
            Review review3 = new Review("Loved the accessories!", user1, 5, null);

            user1.addReview(review1);
            user2.addReview(review2);
            user1.addReview(review3);

            shop.addReview(review1);
            shop.addReview(review2);
            shop.addReview(review3);

            System.out.println("Shop and Review Functionality Test:");
            System.out.println(shop);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testTheaterFunctionality() {
        Theater theater = new Theater("Prime Cinema");
        theater.addMovie("Mad Max");
        theater.addMovie("Avengers: Endgame");
        theater.addMovie("The Matrix");

        theater.removeMovie("Mad Max");

        User user3 = new User("Ayoub");
        User user4 = new User("Sabah");

        Review review1 = new Review("Mind-bending movie!", user3, 5, "The Matrix");
        Review review2 = new Review("Great atmosphere and popcorn.", user4, 4, "Avengers: Endgame");

        user3.addReview(review1);
        user4.addReview(review2);

        System.out.println("Theater Functionality Test:");
        System.out.println(theater);
        System.out.println();
    }
}
