package codedesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestrictSpoofingUser {

    // “Each customer can make X requests per Y seconds”

    // Perform rate limiting logic for provided customer ID. Return true if the
    // request is allowed, and false if it is not.

    private static Map<Integer, List<Long>>  applicationRequestMapperByTimeStamp = new HashMap<>();

    public boolean rateLimit(int customerId){
        List<Long> timeStamps;
        if(applicationRequestMapperByTimeStamp.containsKey(customerId)){
            timeStamps = applicationRequestMapperByTimeStamp.get(customerId);
        } else {
            timeStamps = new ArrayList<>();
        }

        timeStamps.add(System.currentTimeMillis());
        applicationRequestMapperByTimeStamp.put(customerId,timeStamps);
        return RateLimitingUtil.validateRateLimit(timeStamps);
    }
}
