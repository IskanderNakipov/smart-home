package ru.sbt.mipt.oop.processors.fakeProcessors;

import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.processors.EventHandler;



public class FakeDoorProcessor implements EventHandler {

    boolean state = false;
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (!event.isDoorEvent()) return;
        state = !state;
    }

    public boolean getState() {return state;}
}