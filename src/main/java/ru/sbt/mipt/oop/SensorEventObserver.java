package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

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
            for (EventHandler handle : handlers) {
                handle.handle(home, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler){
        handlers.add(eventHandler);
    }
}