package ru.sbt.mipt.oop;


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
