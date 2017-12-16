package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventHandler{
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (!isDoorEvent(event)) return;

        for (Room room : home.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                    } else {
                        door.setOpen(false);
                        AutoProcessor.roomLightsOff(home, room);
                    }
                }
            }
        }
    }

    public static void switchDoor(SmartHome home, SensorEvent event, Room room, Door door) {
        if (event.getType() == DOOR_OPEN) {
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
        } else {
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");

            if (room.getName().equals("hall")) {
                AutoProcessor.allLightsOff(home);
            }
        }
    }
    public static boolean isDoorEvent(SensorEvent event) {
        if ((event.getType() == DOOR_OPEN) || (event.getType() == DOOR_CLOSED)){
            return true;
        }
        return false;
    }
}