package ru.sbt.mipt.oop;

public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystem;

    public AlarmSystem(){
        alarmSystem = new AlarmSystemStateOff(this);
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
    public void onEvent(SensorEvent event) {
        alarmSystem.onEvent(event);
    }

    public void setState(AlarmSystemState newState){
        this.alarmSystem = newState;
    }

}