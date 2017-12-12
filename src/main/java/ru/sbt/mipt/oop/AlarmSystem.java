
package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStates.OFF;
import static ru.sbt.mipt.oop.AlarmSystemStates.ON;
import static ru.sbt.mipt.oop.AlarmSystemStates.WAIT_FOR_PASSWORD;

public class AlarmSystem {

    private AlarmSystemStates state = OFF;

    public AlarmSystemStates getState() {
        return state;
    }

    public void turnOn() {
        if (state == WAIT_FOR_PASSWORD) return;
        else state = ON;
    }

    public void onEvent(SensorEvent event) {
        if(state == OFF) return;
        state = WAIT_FOR_PASSWORD;
    }
}