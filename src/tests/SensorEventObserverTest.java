import org.junit.Test;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.fakeProcessors.*;
import ru.sbt.mipt.oop.processors.EventHandler;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventObserver;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SensorEventObserverTest {
    @Test
    public void setHandlers() throws Exception {
        SmartHome home = new SmartHome();
        SensorEventObserver observer = new SensorEventObserver(home);
        FakeDoorProcessor fakeDoorProcessor = new FakeDoorProcessor();
        FakeLightProcessor fakeLightProcessor = new FakeLightProcessor();
        List<EventHandler> eventHandlers = new ArrayList<>();
        eventHandlers.add(fakeLightProcessor);
        eventHandlers.add(fakeDoorProcessor);

        for (EventHandler handler: eventHandlers) {
            observer.addProcessor(handler);
        }

        assertEquals(2, observer.processors.size());
        for (EventHandler handler: eventHandlers){
            assertTrue(observer.processors.contains(handler));
        }

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        observer.onEvent(event);
        assertTrue(fakeDoorProcessor.getState());
        assertFalse(fakeLightProcessor.getState());
        event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        observer.onEvent(event);
        assertTrue(fakeDoorProcessor.getState());
        assertTrue(fakeLightProcessor.getState());

    }

}