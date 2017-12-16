package ru.sbt.mipt.oop.sensors;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.EventHandler;
import ru.sbt.mipt.oop.processors.EventProcessor;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.processors.ExternalEventProcessor.getNextSensorEvent;


public class SensorEventObserver {
    private Collection<EventHandler> processors = new ArrayList<>();
    private SmartHome home;

    public SensorEventObserver(SmartHome home) {
        this.home = home;
    }

    public void observe() {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            onEvent(event);
            event = getNextSensorEvent();
        }
    }

    public void onEvent(SensorEvent event) {
        System.out.println("Got event: " + event.getType());
        for (EventHandler processor: processors) {
            processor.handle(this.home, event);
        }
    }

    public void addHandler(EventHandler eventHandler){
        processors.add(eventHandler);
    }
}