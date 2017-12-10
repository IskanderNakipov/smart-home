package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LightEventProcessorTest {
    @Test
    public void handle() throws Exception {
        LightEventProcessor processor = new LightEventProcessor();
        SmartHome home = new SmartHome();
        String id = "1";
        Light light = new Light(id, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(), "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, id);
        processor.handle(home, event);
        assertTrue(light.isOn());
    }

}
