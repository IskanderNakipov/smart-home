package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.*;


public class DoorEventProcessorTest {
    @Test
    public void handle() throws Exception {
        DoorEventProcessor doorEventProcessing = new DoorEventProcessor();
        SmartHome home = new SmartHome();
        Door door = new Door(false,"1");

        home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door), "room"));
        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        doorEventProcessing.handle(home, event);
        assertTrue(door.isOpen());
    }
}