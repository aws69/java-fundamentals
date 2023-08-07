import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {

    
    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        //===========
        System.out.println("========================================");
        flipNHeads(1);

        System.out.println("========================================");
        clock();

    }


    // Pluralize function
    public static String pluralize(String word, int number) {
        if (number != 1) {
            return word + "s";
        } else {
            return word;
        }
    }

    // =================================================================================================================

    // Flip coin function
    public static void flipNHeads(int n) {
        int flips = 0;
        int headsCount = 0;
        Random random = new Random();

        while (headsCount < n) {
            double randomValue = random.nextDouble();
            if (randomValue < 0.5) {
                System.out.println("tails");
                headsCount = 0;
            } else {
                System.out.println("heads");
                headsCount++;
            }
            flips++;
        }

        System.out.println("It took " + flips + " flips to flip " + n + " head" + (n > 1 ? "s" : "") + " in a row.");
    }

    // =================================================================================================================

    //Command Line Clock function

    public static void clock() {
        //normal clock code 
        /*
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(time);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */

        //Stretch Goals code 
        long prevTime = System.nanoTime();
        long count = 0;

        while (true) {
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.print(time + " ");

            count++;

            long currentTime = System.nanoTime();
            double elapsedSeconds = (currentTime - prevTime) / 1_000_000_000.0;
            prevTime = currentTime;

            double processingSpeed = count / elapsedSeconds;

            if (processingSpeed >= 1_000_000_000) {
                System.out.printf("%.6f GHz%n", processingSpeed / 1_000_000_000.0);
            } else if (processingSpeed >= 1_000_000) {
                System.out.printf("%.6f MHz%n", processingSpeed / 1_000_000.0);
            } else if (processingSpeed >= 1_000) {
                System.out.printf("%.6f kHz%n", processingSpeed / 1_000.0);
            } else {
                System.out.printf("%.6f Hz%n", processingSpeed);
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}