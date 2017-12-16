import org.junit.Test;
import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.sensors.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;


public class DoorEventProcessorTest {
    @Test
    public void creationTest() throws Exception {
        DoorEventProcessor doorEventProcessing = new DoorEventProcessor();
        SmartHome home = new SmartHome();
        Door door = new Door(false,"1");
        assertFalse(door.isOpen());
        home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door), "room"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        doorEventProcessing.handle(home, event);
        assertTrue(door.isOpen());
    }
    @Test
    public void checkId() throws Exception {
        String id = "1";
        Door door = new Door(false, id);
        assertTrue(door.getId().equals(id));
    }
}