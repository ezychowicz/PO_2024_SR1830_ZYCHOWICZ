package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();  //animals jest w obu mapach

    public abstract Vector2d findUpperRightBoundary();
    public abstract Vector2d findLowerLeftBoundary();
    public abstract void canMoveTo(Vector2d position);
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
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
    public String toString(){
        Vector2d lowerLeftBoundary = findLowerLeftBoundary();
        Vector2d upperRightBoundary = findUpperRightBoundary();
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(lowerLeftBoundary, upperRightBoundary);
    }

    @Override
    public List<WorldElement> getElements(){
        return new ArrayList<>(animals.values());
    }

}

