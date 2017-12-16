package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

public class Door implements Actionable {
    private final String id;
    private boolean state;

    public Door(boolean isOpen, String id) {
        this.state = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setState(boolean open) {
        state = open;
    }

    public boolean isOpen() {
        return state;
    }

    @Override
   public void executeAction(Action action) {
        action.execute(this);
    }
}

