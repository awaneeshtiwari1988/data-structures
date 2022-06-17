package codedesign;

import java.util.List;

public class RateLimitingUtil {

    public static  boolean validateRateLimit(List<Long> timeStamps){
        Configurations configurations = ConfigurationReader.readConfigValues();
        String numberOfRequests = configurations.getConfigurationMap()
                .getOrDefault("numberOfRequests", String.valueOf(1));
        String numberOfSeconds = configurations.getConfigurationMap()
                .getOrDefault("numberOfSeconds",String.valueOf(1));

        int counter = 1;
        long timeStampDiff = 0l;
        for(int i = timeStamps.size() - 2; i > 0; i--){
            counter++;
            timeStampDiff = timeStamps.get(i+1) - timeStamps.get(i);

            if(timeStampDiff <= Long.parseLong(numberOfSeconds) && counter >= Integer.parseInt(numberOfRequests)){
                return false;
            } else if(timeStampDiff > 2){
                long latestRequestTimeStamp = timeStamps.get(timeStamps.size() - 1);
                timeStamps.clear();
                timeStamps.add(latestRequestTimeStamp);
                return true;
            }
        }

        return true;
    }
}
