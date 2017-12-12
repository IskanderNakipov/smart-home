package ru.sbt.mipt.oop;

public class AlarmSystemStateOn implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem system) {
        alarmSystem =system;

    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.ON;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onEvent(SensorEvent event) {
        alarmSystem.setState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }
}