package ru.sbt.mipt.oop.sensors;

import static ru.sbt.mipt.oop.sensors.SensorEventType.*;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public boolean isDoorEvent() {
        if ((getType() == DOOR_OPEN) || (getType() == DOOR_CLOSED)) {
            return true;
        }
        return false;
    }

    public boolean isLightEvent() {
        if ((getType() == LIGHT_ON) ||  (getType() == LIGHT_OFF)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
