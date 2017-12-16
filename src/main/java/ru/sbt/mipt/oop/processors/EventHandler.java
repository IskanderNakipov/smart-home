package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;

public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}