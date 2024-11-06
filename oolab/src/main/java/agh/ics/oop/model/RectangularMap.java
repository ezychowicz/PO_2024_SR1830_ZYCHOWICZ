package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static agh.ics.oop.model.MoveDirection.*;

public class RectangularMap implements WorldMap {
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d upperRightBoundary;
    private final Vector2d lowerLeftBoundary;

    public RectangularMap(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.upperRightBoundary = new Vector2d(this.width, this.height);
        this.lowerLeftBoundary = new Vector2d(0, 0);
    }


    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPos())) {
            animals.put(animal.getPos(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsValue(animal)) {
            animals.remove(animal.getPos());  //usuń zwierzaka z aktualnej pozycji na mapie
            animal.move(direction, this); //przenieś zwierzaka, chyba że sie nie da to nic nie zmieniaj
            animals.put(animal.getPos(), animal); //umieść na mapie zwierzaka tam gdzie go przeniosłeś (lub przywróć)
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return isOccupied(position) ? animals.get(position) : null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && isOnMap(position);

    }

    @Override
    public String toString() {
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(lowerLeftBoundary, upperRightBoundary);
    }


    public boolean isOnMap(Vector2d position) {
        return position.precedes(upperRightBoundary) && position.follows(lowerLeftBoundary);
    }

    private Vector2d moveForwardBackward(Animal animal, MoveDirection currMoveDirection) {
        Vector2d move;
        switch (animal.getDirection()) {
            case NORTH ->
                    move = (currMoveDirection == FORWARD ? MapDirection.NORTH_UNIT_VECTOR : MapDirection.SOUTH_UNIT_VECTOR);
            case SOUTH ->
                    move = (currMoveDirection == FORWARD ? MapDirection.SOUTH_UNIT_VECTOR : MapDirection.NORTH_UNIT_VECTOR);
            case EAST ->
                    move = (currMoveDirection == FORWARD ? MapDirection.EAST_UNIT_VECTOR : MapDirection.WEST_UNIT_VECTOR);
            case WEST ->
                    move = (currMoveDirection == FORWARD ? MapDirection.WEST_UNIT_VECTOR : MapDirection.EAST_UNIT_VECTOR);
            default -> throw new IllegalStateException("Unexpected value: " + animal.getDirection());
        }
        return animal.getPos().add(move);
    }
}
