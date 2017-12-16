package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.sbt.mipt.oop.entities.*;

public class SmartHomeSaver {
    public static void save(SmartHome smartHome, String outputFileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        Path path = Paths.get(outputFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
            System.out.println("\nSmartHome final state was successfully saved");
        } catch (Exception e){
            System.out.println("\nSmartHome final state was not saved");
        }
    }
}