package com.ashnik.kafkaconnector;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {
    public static List<String> validateData(String jsonData) {
        JsonArray jsonArray = JsonParser.parseString(jsonData).getAsJsonArray();
        List<String> validData = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            if (element.getAsJsonObject().has("title") && !element.getAsJsonObject().get("title").getAsString().isEmpty()) {
                validData.add(element.toString());
            }
        }
        return validData;
    }
}
