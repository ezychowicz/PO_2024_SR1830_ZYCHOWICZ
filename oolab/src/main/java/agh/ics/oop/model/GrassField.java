package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses;
    public GrassField(int grassCount) {
        this.grasses = new HashMap<Vector2d, Grass>();
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) Math.sqrt(10 * grassCount), (int) Math.sqrt(10 * grassCount), grassCount);
        for (Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }

    }
//    @Override
//    public boolean place(Animal animal) {
//        if (canMoveTo(animal.getPos())) {
//            animals.put(animal.getPos(), animal);
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean canMoveTo(Vector2d position) { //inny validator
        return !animals.containsKey(position);
    }

//    @Override
//    public void move(Animal animal, MoveDirection direction) {
//        if (animals.containsValue(animal)) {
//            animals.remove(animal.getPos());  //usuń zwierzaka z aktualnej pozycji na mapie
//            animal.move(direction, this); //przenieś zwierzaka, chyba że sie nie da to nic nie zmieniaj
//            animals.put(animal.getPos(), animal); //umieść na mapie zwierzaka tam gdzie go przeniosłeś (lub przywróć)
//        }
//    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null) { //priorytet animals
            return super.objectAt(position);
        };
        return grasses.get(position);
    }

    @Override
    public Vector2d findUpperRightBoundary() {
        Vector2d currUpperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d position : animals.keySet()) {
            currUpperRight = currUpperRight.upperRight(position);
        }
        for (Vector2d position : grasses.keySet()) {
            currUpperRight = currUpperRight.upperRight(position);
        }
        return currUpperRight;
    }


    @Override
    public Vector2d findLowerLeftBoundary() {
        Vector2d currLowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Vector2d position : animals.keySet()) {
            currLowerLeft = currLowerLeft.lowerLeft(position);
        }
        for (Vector2d position : grasses.keySet()) {
            currLowerLeft = currLowerLeft.lowerLeft(position);
        }
        return currLowerLeft;
    }

    public Map<Vector2d, Grass> getGrasses() {
        return grasses;
    }

//    public Map<Vector2d, Animal> getAnimals() {
//        return animals;
//    }

//    @Override
//    public String toString() {
//        Vector2d upperRightBoundary = findUpperRightBoundary();
//        Vector2d lowerLeftBoundary = findLowerLeftBoundary();
//        MapVisualizer mapVis = new MapVisualizer(this);
//        return mapVis.draw(lowerLeftBoundary, upperRightBoundary);
//    }

}
