package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static JsonNode config;

    static {
        try {
            String configPath = System.getProperty("user.dir") + "/config.json";
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readTree(new File(configPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.json file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        JsonNode value = config.get(key);
        if (value != null && !value.isNull()) {
            return value.asText();
        }
        return null;
    }
}