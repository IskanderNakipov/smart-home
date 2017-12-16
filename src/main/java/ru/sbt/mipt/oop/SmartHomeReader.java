
package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import ru.sbt.mipt.oop.entities.*;

public class SmartHomeReader {

    public static SmartHome read(String inputFileName) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(inputFileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}