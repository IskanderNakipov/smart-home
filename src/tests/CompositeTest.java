
package ru.sbt.mipt.oop;
import org.junit.Test;
import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class TestComposite {
    @Test
    public void actionableComposite(){
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors1 = Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");

        List<Light> lights2 = Arrays.asList(new Light("3", true));
        List<Door> doors2 = Arrays.asList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");

        SmartHome home = new SmartHome(Arrays.asList(kitchen, bathroom));

        Set<Object> unvisited = new HashSet<>();
        unvisited.add(home);
        unvisited.add(kitchen);
        unvisited.add(bathroom);
        unvisited.addAll(lights1);
        unvisited.addAll(lights2);
        unvisited.addAll(doors1);
        unvisited.addAll(doors2);

        home.executeAction(obj ->{
            unvisited.remove(obj);
        });
        System.out.println(unvisited);
        assertTrue(unvisited.isEmpty());
    }
}