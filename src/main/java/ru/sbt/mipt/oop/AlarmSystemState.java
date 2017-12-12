package ru.sbt.mipt.oop;

public interface AlarmSystemState {
    AlarmSystemStates getState();

    void turnOn();

    void onEvent(SensorEvent event);
}