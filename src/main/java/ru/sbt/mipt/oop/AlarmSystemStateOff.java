package ru.sbt.mipt.oop;

public class AlarmSystemStateOff implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOff(AlarmSystem system) {
        alarmSystem =system;

    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.OFF;
    }

    @Override
    public void turnOn() {
        alarmSystem.setState(new AlarmSystemStateOn(alarmSystem));
    }

    @Override
    public void onEvent(SensorEvent event) {
        return;
    }
}