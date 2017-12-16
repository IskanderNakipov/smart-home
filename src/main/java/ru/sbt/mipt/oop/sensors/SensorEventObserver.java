package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.EventHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.sbt.mipt.oop.processors.ExternalEventProcessor.getNextSensorEvent;

public class SensorEventObserver {
    private Collection<EventHandler> handlers = new ArrayList<>();
    private SmartHome home;

    public SensorEventObserver(SmartHome home){
        this.home = home;
    }

    public void runEventCycle(){
        SensorEvent event = getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler : handlers) {
                handler.handle(home, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler){
        handlers.add(eventHandler);
    }

    public void setHandlers(List<EventHandler> handlers) {
        this.handlers = handlers;
    }
}