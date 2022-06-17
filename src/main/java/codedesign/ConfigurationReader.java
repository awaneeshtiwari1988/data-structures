package codedesign;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationReader {

    public static Configurations readConfigValues(){
        Map<String, String> configurationsMap = new HashMap<>();
        configurationsMap.put("numberOfRequests", String.valueOf(3));
        configurationsMap.put("numberOfSeconds", String.valueOf(1));
        Configurations configurations = new Configurations();
        configurations.setConfigurationMap(configurationsMap);
        return configurations;
    }
}
