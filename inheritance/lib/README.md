# Restaurant Review Library

This library provides classes to manage restaurant reviews, users, and restaurant chains. It allows users to create reviews for specific restaurants, associate users with their reviews, and calculate average ratings for restaurants.

## Architecture Overview

The library is designed using object-oriented programming (OOP) principles and includes the following classes:

1. `User`: Represents a user who can write reviews. Users can be associated with multiple reviews.

2. `Review`: Represents a review written by a user for a restaurant. Reviews include information such as the review body, author, stars, and the restaurant it is about.

3. `Restaurant`: Represents a restaurant entity. Restaurants can have multiple reviews associated with them. The average rating for a restaurant is calculated based on its reviews.

4. `RestaurantChain`: Represents a chain of restaurants. Restaurants can be added to a chain, and chains can have multiple associated restaurants.

## How to Test

To test the functionality of the Restaurant Review Library, follow these steps:

1. Clone or download this repository to your local machine.

2. Open your terminal or command prompt and navigate to the directory containing the downloaded files.

3. Compile the Java source files using the `javac` command. For example:

4. Run the compiled `Main` class using the `java` command:
This will execute the provided test cases and output the results to the console.

5. Observe the output in the console to see the functionality of the library in action. The output will display restaurant details, reviews, and average ratings.

