package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.sensors.SensorCommand;
import ru.sbt.mipt.oop.sensors.SensorEvent;


public class AutoEventProcessor implements EventHandler{
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (!event.isDoorEvent()) return;
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId()) &&
                        room.getName().equals("hall")) { turnAllLights(smartHome, false);}
            }
        }
    }

    public void turnAllLights(SmartHome smartHome, boolean state) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setState(state);
            }
        }
    }
}