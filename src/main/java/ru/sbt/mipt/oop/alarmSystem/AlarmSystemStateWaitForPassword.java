package ru.sbt.mipt.oop;

import java.util.Scanner;

public class AlarmSystemStateWaitForPassword implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private int password;

    public AlarmSystemStateWaitForPassword(AlarmSystem system, int password) {
        alarmSystem = system;
        this.password = password;
        //enterPassword();
    }

    public void enterPassword() {

        int wrongAttempts = 0;
        Scanner in = new Scanner(System.in);
        int pin;
        pin = in.nextInt();
        while (pin != password) {
            wrongAttempts += 1;
            if (wrongAttempts >= 3) { alarmSystem.setState(new AlarmSystemStateAlarm(alarmSystem, password)); }
            pin = in.nextInt();
        }

        alarmSystem.setState(new AlarmSystemStateOn(alarmSystem, password));
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
    public void onEvent(SensorEvent sensorEvent) {
        return;
    }
}
