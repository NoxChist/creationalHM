import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        List<Integer> list, result;
        Logger logger = Logger.getInstance();
        Filter filter;
        int size = 0, maxValue = 0, threshold = 0;

        logger.log("Program start.");

        logger.log("Requesting user input to get the list size and max value.");
        System.out.print("Enter list size: ");
        try {
            size = in.nextInt();
            logger.log("List size: " + size);
        } catch (Exception e) {
            logger.log("Error during scan user input [size]");
        }
        System.out.print("Enter max value: ");
        try {
            maxValue = in.nextInt();
            logger.log("Max value: " + maxValue);
        } catch (Exception e) {
            logger.log("Error during scan user input [maxValue]");
        }

        logger.log("Creating and filling a list with random values.");
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(maxValue) + 1);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                logger.log(e.getMessage());
            }
        }
        System.out.println("Your list with random values: " + list);

        logger.log("Requesting user input to get the threshold for filter.");
        System.out.print("Enter threshold for filter: ");
        try {
            threshold = in.nextInt();
            logger.log("Threshold: " + threshold);
        } catch (Exception e) {
            logger.log("Error during scan user input [threshold]");
        }

        filter = new Filter(threshold);
        logger.log("A new filter has been created.");
        result = filter.filterOut(list);
        if (result != null) {
            logger.log("Filter returned result");
        }
        logger.log("Print the result to the console");

        System.out.println("Result list: " + result);
        logger.log("Program completed.");
    }
}
