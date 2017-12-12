package ru.sbt.mipt.oop;

import org.junit.Test;

import static ru.sbt.mipt.oop.AlarmSystemStates.OFF;
import static ru.sbt.mipt.oop.AlarmSystemStates.ON;
import static ru.sbt.mipt.oop.AlarmSystemStates.WAIT_FOR_PASSWORD;

import static org.junit.Assert.assertEquals;

public class AlarmSystemTest {
    @Test
    public void testOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(OFF, alarmSystem.getState());
    }

    @Test
    public void testOn(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(ON, alarmSystem.getState());
    }

    @Test
    public void testPasswordWaiting(){
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent event = createSensorEvent();
        alarmSystem.turnOn();
        alarmSystem.onEvent(event);
        assertEquals(WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void testOnEventWhenSystemIsOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.onEvent(createSensorEvent());
        assertEquals(OFF, alarmSystem.getState());
    }


    public SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }
}