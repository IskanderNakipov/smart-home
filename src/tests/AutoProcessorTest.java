import ru.sbt.mipt.oop.processors.*;

import org.junit.Test;
import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.processors.iterators.*;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AutoProcessorTest {
    @Test
    public void testHallDoorClosed() {
        SmartHome smartHome = new SmartHome();
        Door hall_door = new Door(true, "1");
        Light hall_light = new Light("1", true);
        smartHome.addRoom(new Room(Arrays.asList(hall_light), Arrays.asList(hall_door), "hall"));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, hall_door.getId());
        AutoEventProcessor processor = new AutoEventProcessor();
        processor.handle(smartHome, event);

        LightIterator lightIterator = new LightIterator(smartHome);

        while (lightIterator.hasNext())
            assertFalse(lightIterator.next().isOn());
    }
    @Test
    public void testNotHallDoorClosed() {
        SmartHome smartHome = new SmartHome();
        Door door = new Door(true, "1");
        Light light = new Light("1", true);
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "room"));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, door.getId());
        AutoEventProcessor processor = new AutoEventProcessor();
        processor.handle(smartHome, event);

        LightIterator lightIterator = new LightIterator(smartHome);

        while (lightIterator.hasNext())
            assertTrue(lightIterator.next().isOn());
    }
}