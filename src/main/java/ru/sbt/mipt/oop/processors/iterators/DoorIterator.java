package ru.sbt.mipt.oop.processors.iterators;

import ru.sbt.mipt.oop.entities.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DoorIterator implements Iterator<Door> {

    private final SmartHome home;
    private List<Room> rooms;
    private int currentRoom;
    private int currentDoor;

    public DoorIterator(SmartHome home) {
        this.home = home;
        this.currentDoor = 0;
        this.currentRoom = 0;
        this.rooms = new ArrayList<>(home.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (currentRoom > rooms.size() - 1) return false;
        Room room  = rooms.get(currentRoom);
        if (currentDoor > new ArrayList<>(room.getDoors()).size() - 1) return false;
        return true;
    }

    @Override
    public Door next() {
        List<Door> currentRoomDoors = new ArrayList<>(rooms.get(currentRoom).getDoors());
        Door door;
        if (currentRoomDoors.size() == 1) {
            if (currentDoor == 0) {
                door = currentRoomDoors.get(currentDoor);
                currentRoom++;
                currentDoor = 0;
            }
            else throw new IllegalStateException();
        }
        else {
            if (currentDoor < currentRoomDoors.size() - 1) {
                door = currentRoomDoors.get(currentDoor);
                currentDoor++;
            }
            else if (currentDoor == currentRoomDoors.size() - 1) {
                door = currentRoomDoors.get(currentDoor);
                currentRoom++;
                currentDoor = 0;
            }
            else throw new IllegalStateException();
        }
        return door;
    }
}