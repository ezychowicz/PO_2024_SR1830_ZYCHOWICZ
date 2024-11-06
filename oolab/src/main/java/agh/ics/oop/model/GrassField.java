package agh.ics.oop.model;

public class GrassField implements WorldMap{
    public final int grassCount;
    public GrassField(int grassCount, int grassCount1) {
        this.grassCount = grassCount;
    }
    @Override
    public boolean place(Animal element) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
}
