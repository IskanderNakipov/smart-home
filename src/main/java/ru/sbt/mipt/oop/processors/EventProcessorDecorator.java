package ru.sbt.mipt.oop.processors;


import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.alarmSystem.AlarmSystem;

import java.util.Collection;

public class EventProcessorDecorator extends EventProcessor {

    public EventProcessorDecorator(SmartHome smartHome, AlarmSystem alarmSystemState) {
        super(smartHome, alarmSystemState);
    }
    public static void securedSensorEventProcessor(Collection<EventHandler> eventHandlers, SensorEvent event){
        EventProcessor.alarmEventProcessor(event);
        EventProcessor.sensorEventProcessor(eventHandlers, event);
    }

}
