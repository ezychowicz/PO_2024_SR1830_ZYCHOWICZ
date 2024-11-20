package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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


    @Override
    public void canMoveTo(Vector2d position) throws IncorrectPositionException{ //inny validator
        if (animals.containsKey(position)){
            throw new IncorrectPositionException(position);
        }
    }



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

    @Override
    public List<WorldElement> getElements() {
        List <WorldElement> worldElements = super.getElements();
        worldElements.addAll(grasses.values());
        return worldElements;
    }
    public Map<Vector2d, Grass> getGrasses() {
        return grasses;
    }


}
