import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Start filter source.");
        for (int num : source) {
            if (num >= threshold) {
                logger.log(String.format("Number \"%d\" passes the filter", num));
                result.add(num);
            } else {
                logger.log(String.format("Number \"%d\" less than threshold.", num));
            }
        }
        logger.log(String.format("%d numbers out of %d passed filter", result.size(), source.size()));
        logger.log("The filter has completed.");
        return result;
    }
}
