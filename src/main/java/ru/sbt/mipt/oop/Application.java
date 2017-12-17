package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.alarmSystem.*;
import ru.sbt.mipt.oop.sensors.SensorCommand;
import ru.sbt.mipt.oop.sensors.SensorEventObserver;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
        AlarmSystemState alarmSystemState = (AlarmSystemState) ctx.getBean("alarmSystem");

        sensorEventObserver.observe();
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}