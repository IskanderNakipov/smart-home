package ru.sbt.mipt.oop;

public class AlarmSystemStateOff implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private int password;

    public AlarmSystemStateOff(AlarmSystem system, int password) {
        alarmSystem = system;
        this.password = password;
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.OFF;
    }

    @Override
    public void turnOn() {
        alarmSystem.setState(new AlarmSystemStateOn(alarmSystem, this.password));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        return;
    }
}
