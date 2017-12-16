package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;

public class AutoProcessorDecorator implements EventHandler {
    private final EventHandler handler;

    public AutoProcessorDecorator(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        System.out.println("This is a decorator " + System.currentTimeMillis() / 1000);
        handler.handle(home, event);
    }
}