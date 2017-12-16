package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.alarmSystem.AlarmSystemState;

import java.util.Collection;

public class EventProcessor {
    private static SmartHome home;
    private static AlarmSystemState state;

    public EventProcessor(SmartHome smartHome, AlarmSystemState alarmSystemState){
        this.home = smartHome;
        this.state = alarmSystemState;
    }

    public static void sensorEventProcessor(Collection<EventHandler> eventHandlers, SensorEvent event) {
        System.out.println("Got event: " + event);
        for (EventHandler handle : eventHandlers) {
            handle.handle(home, event);
        }
        return;
    }

    public static void alarmEventProcessor(SensorEvent event){
        state.onEvent(event);
        return;
    }
}