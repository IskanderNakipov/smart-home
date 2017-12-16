import org.junit.Test;
import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.processors.LightEventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LightEventProcessorTest {
    @Test
    public void creationTest() throws Exception {
        LightEventProcessor processor = new LightEventProcessor();
        SmartHome home = new SmartHome();
        String id = "1";
        Light light = new Light(id, false);
        assertFalse(light.isOn());
        home.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, id);
        processor.handle(home, event);
        assertTrue(light.isOn());
    }
    @Test
    public void checkId() throws Exception {
        String id = "1";
        Light light = new Light(id, false);
        assertTrue(light.getId()==id);
    }

}
