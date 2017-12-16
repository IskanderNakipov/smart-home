package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

public class Light implements Actionable {
    private boolean state;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.state = isOn;
    }

    public boolean isOn() {
        return state;
    }

    public String getId() {
        return id;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);

    }
}
