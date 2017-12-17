import org.junit.Test;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.sensors.SensorEventObserver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SensorEventObserverTest {
    @Test
    public void setHandlers() throws Exception {
        SmartHome home = new SmartHome();
        SensorEventObserver observer = new SensorEventObserver(home);
        List<EventHandler> eventHandlers = new ArrayList<>();
        eventHandlers.add(new LightEventProcessor());
        eventHandlers.add(new DoorEventProcessor());
        eventHandlers.add(new AutoEventProcessor());

        for (EventHandler handler: eventHandlers) {
            observer.addProcessor(handler);
        }

        assertEquals(3, observer.processors.size());
        for (EventHandler handler: eventHandlers){
            assertTrue(observer.processors.contains(handler));
        }
    }

}