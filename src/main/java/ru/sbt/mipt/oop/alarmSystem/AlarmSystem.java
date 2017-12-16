package ru.sbt.mipt.oop;


public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystem;
    private int password;

    public AlarmSystem(int password){
        alarmSystem = new AlarmSystemStateOff(this, password);
        this.password = password;
    }

    public void setState(AlarmSystemState newState){
        this.alarmSystem = newState;
    }

    @Override
    public AlarmSystemStates getState() {
        return alarmSystem.getState();
    }

    @Override
    public void turnOn() {
        alarmSystem.turnOn();
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.onEvent(sensorEvent);
    }

}