package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateOn implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private int password;

    public AlarmSystemStateOn(AlarmSystem system, int password) {
        alarmSystem = system;
        this.password = password;
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.ON;
    }

    @Override
    public void enterPassword() {
        return;
    }

    @Override
    public void turnOn() {
        alarmSystem.setState(new AlarmSystemStateOff(alarmSystem, this.password));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.setState(new AlarmSystemStateWaitForPassword(alarmSystem, this.password));
    }
}
