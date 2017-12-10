package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = JsonReader.read();
        SensorEventObserver observer = new SensorEventObserver(smartHome);
        configurateHandlers(observer);
        observer.runEventCycle();

    }

    public static void configurateHandlers(SensorEventObserver sensorEventObserver) {
        sensorEventObserver.addHandler(new LightEventProcessor());
        sensorEventObserver.addHandler(new DoorEventProcessor());
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}