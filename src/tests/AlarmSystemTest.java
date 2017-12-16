import ru.sbt.mipt.oop.sensors.*;

import org.junit.Test;
import ru.sbt.mipt.oop.alarmSystem.AlarmSystem;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import static ru.sbt.mipt.oop.alarmSystem.AlarmSystemStates.OFF;
import static ru.sbt.mipt.oop.alarmSystem.AlarmSystemStates.ON;
import static ru.sbt.mipt.oop.alarmSystem.AlarmSystemStates.WAIT_FOR_PASSWORD;

import static org.junit.Assert.assertEquals;

public class AlarmSystemTest {

    public SensorEvent newEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }

    @Test
    public void testNew(){
        AlarmSystem alarmSystem = new AlarmSystem(0);
        assertEquals(OFF, alarmSystem.getState());
    }

    @Test
    public void testTurnOn(){
        AlarmSystem alarmSystem = new AlarmSystem(0);
        alarmSystem.turnOn();
        assertEquals(ON, alarmSystem.getState());
    }

    @Test
    public void testPasswordWaiting(){
        SensorEvent event = newEvent();
        AlarmSystem alarmSystem = new AlarmSystem(0);
        alarmSystem.turnOn();
        alarmSystem.onEvent(event);
        assertEquals(WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void testOff(){
        AlarmSystem alarmSystem = new AlarmSystem(0);
        alarmSystem.onEvent(newEvent());
        assertEquals(OFF, alarmSystem.getState());
    }

}