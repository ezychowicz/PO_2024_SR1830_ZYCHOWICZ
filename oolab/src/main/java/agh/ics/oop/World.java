package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = null;
        try {
            directions = OptionsParser.parse(args);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("error: " + e.getMessage());
            return;
        }
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        AbstractWorldMap grassField = new GrassField(10);
        ConsoleMapDisplay observer1 = new ConsoleMapDisplay();
        grassField.addObserver(observer1);
        Simulation simulation = new Simulation(positions, directions, grassField);
        simulation.run();
    }
    public static void run(MoveDirection[] input){
        for (MoveDirection arg : input) {
            switch (arg) {
                case MoveDirection.FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case MoveDirection.BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case MoveDirection.RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case MoveDirection.LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
}
