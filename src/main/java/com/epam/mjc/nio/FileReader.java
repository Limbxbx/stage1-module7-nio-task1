package com.epam.mjc.nio;

import java.io.File;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class FileReader {

    public static Profile getDataFromFile(File file) throws IOException {
        String data = new String(Files.readAllBytes(file.toPath()));
        Map<String, String> keyValues = parseData(data);
        String name = keyValues.get("Name");
        Integer age = Integer.parseInt(keyValues.get("Age"));
        String email = keyValues.get("Email");
        Long phone = Long.parseLong(keyValues.get("Phone"));
        return new Profile(name, age, email, phone);
    }

    private static Map<String, String> parseData(String data) {
        Map<String, String> keyValues = new HashMap<>();
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] keyValue = line.split(": ");
            keyValues.put(keyValue[0], keyValue[1].trim());
        }
        return keyValues;
    }
}
