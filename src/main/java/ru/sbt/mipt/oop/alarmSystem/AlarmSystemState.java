package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public interface AlarmSystemState {

    AlarmSystemStates getState();
    void enterPassword();
    void turnOn();
    void onEvent(SensorEvent event);

}