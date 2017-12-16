package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateAlarm implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private int password;

    public AlarmSystemStateAlarm(AlarmSystem system, int password) {
        alarmSystem = system;
        this.password = password;
    }

    @Override
    public void enterPassword() {
        return;
    }

    @Override
    public AlarmSystemStates getState() {
        return AlarmSystemStates.ALARM;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        return;
    }
}
