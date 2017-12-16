package ru.sbt.mipt.oop.processors;

import static ru.sbt.mipt.oop.sensors.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.sensors.SensorEventType.LIGHT_ON;

import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.processors.iterators.LightIterator;

public class LightEventProcessor implements EventHandler{
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (!event.isLightEvent()) return;
        LightIterator iterator = new LightIterator(home);
        while (iterator.hasNext()) {
            Light light = iterator.next();
            if (light.getId().equals(event.getObjectId())) {
                switchLight(event, light);
            }
        }
    }


    public static void switchLight(SensorEvent event, Light light) {
        if (event.getType() == LIGHT_ON) {
            light.setState(true);
            System.out.println("Light " + light.getId() + " was turned on.");
        } else {
            light.setState(false);
            System.out.println("Light " + light.getId() + " was turned off.");
        }
    }
}