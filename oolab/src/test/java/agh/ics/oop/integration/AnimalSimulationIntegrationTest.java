package agh.ics.oop.integration;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AnimalSimulationIntegrationTest {
    @Test
    public void isInputParsingWorkingWithSimulationCorrectly() { //nie ma sensu testować samego parseowania, bo jest to zrobione dość dokładnie w OptionsParserTest
        String[] input = {"f", "f", "f", "l", "b", "e", "W", "l", "b", "b", "r", "l", "b", "3"};
        List<Vector2d> positions = List.of(new Vector2d(2,2));

        List<MoveDirection> directions = OptionsParser.parse(input);
        Simulation sim = new Simulation(positions, directions);
        sim.run();
        MapDirection endingDirection = sim.getAnimalsList().getFirst().getDirection();
        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        assertEquals(new Vector2d(3,4), endingPosition);
        assertEquals(endingDirection, MapDirection.SOUTH);
    }

    @Test
    public void isUpperBoundarySolid(){
        List<Vector2d> positions = List.of(new Vector2d(2,4));
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD);

        Simulation sim = new Simulation(positions, directions);
        sim.run();

        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        assertEquals(new Vector2d(2,4), endingPosition);
    }

    @Test
    public void isLowerBoundarySolid(){
        List<Vector2d> positions = List.of(new Vector2d(2,0));
        List<MoveDirection> directions = List.of(MoveDirection.BACKWARD);

        Simulation sim = new Simulation(positions, directions);
        sim.run();

        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        assertEquals(new Vector2d(2,0), endingPosition);
    }

    @Test
    public void isLeftBoundarySolid(){
        List<Vector2d> positions = List.of(new Vector2d(0,2));
        List<MoveDirection> directions = List.of(MoveDirection.LEFT, MoveDirection.FORWARD);

        Simulation sim = new Simulation(positions, directions);
        sim.run();

        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        assertEquals(new Vector2d(0,2), endingPosition);
    }

    @Test
    public void isRightBoundarySolid(){
        List<Vector2d> positions = List.of(new Vector2d(4,2));
        List<MoveDirection> directions = List.of(MoveDirection.RIGHT, MoveDirection.FORWARD);

        Simulation sim = new Simulation(positions, directions);
        sim.run();

        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        assertEquals(new Vector2d(4,2), endingPosition);
    }

    @Test
    public void stationaryOrientationChanges(){
        //given
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        List<MoveDirection> directions = List.of(
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.LEFT);


        Simulation sim = new Simulation(positions, directions);
        sim.run();

        MapDirection endingDirection = sim.getAnimalsList().getFirst().getDirection();
        assertEquals(MapDirection.EAST, endingDirection);

    }

    @Test
    public void AllValidMovement(){
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD);

        Simulation sim = new Simulation(positions, directions);
        sim.run();

        Vector2d endingPosition = sim.getAnimalsList().getFirst().getPos();
        MapDirection endingDirection = sim.getAnimalsList().getFirst().getDirection();
        assertEquals(new Vector2d(3,2), endingPosition);
        assertEquals(MapDirection.NORTH, endingDirection);
    }
}
