package ru.sbt.mipt.oop;

public class AlarmSystemStateWaitForPassword implements AlarmSystemState {
    private final AlarmSystem alarmSystem;

    public AlarmSystemStateWaitForPassword(AlarmSystem system) {
        alarmSystem =system;

    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onEvent(SensorEvent event) {
        return;
    }
}