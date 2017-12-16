package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorCommand;
import ru.sbt.mipt.oop.sensors.SensorEventObserver;
import ru.sbt.mipt.oop.processors.*;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeReader.read("smart-home-1.js");
        SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
        sensorEventObserver.addHandler(new LightEventProcessor());
        sensorEventObserver.addHandler(new DoorEventProcessor());
        sensorEventObserver.observe();

    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}