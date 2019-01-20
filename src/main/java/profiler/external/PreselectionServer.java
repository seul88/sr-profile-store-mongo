package profiler.external;

import java.util.Random;

public class PreselectionServer {

    public String sendRecommendation(String userId) {

        Random r = new Random();
        int low = 1;
        int high = 65133;
        int result = r.nextInt(high - low) + low;

        return Integer.toString(result);
    }

}
