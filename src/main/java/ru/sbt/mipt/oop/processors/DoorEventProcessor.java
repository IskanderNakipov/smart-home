package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.processors.iterators.DoorIterator;

import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_OPEN;


public class DoorEventProcessor implements EventHandler {
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (!event.isDoorEvent()) return;
        DoorIterator iterator = new DoorIterator(home);
        while (iterator.hasNext()) {
            Door door = iterator.next();
            if (door.getId().equals(event.getObjectId())) {
                switchDoor(event, door);
            }
        }
    }


    public static void switchDoor(SensorEvent event, Door door) {
        if (door.getId().equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                door.setState(true);
                System.out.println("Door " + door.getId() + " is opened now");
            } else if (event.getType() == DOOR_CLOSED) {
                door.setState(false);
                System.out.println("Door " + door.getId() + " is closed now");
            }
        }
    }
}