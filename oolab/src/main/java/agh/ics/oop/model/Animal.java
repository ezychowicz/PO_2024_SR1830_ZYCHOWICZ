package agh.ics.oop.model;

public class Animal {
    private MapDirection direction;
    private Vector2d pos;

    public Animal(Vector2d startPosition){
        this.direction = MapDirection.NORTH;
        this.pos = startPosition;
    }

    public Animal() {
        this(new Vector2d(2,2));
    }
    @Override
    public String toString() {
        return "(%s, %s)".formatted(direction, pos); //%s robi toString na direction i pos (wbudowane toString bedzie uzyte tutaj)
    }
    public boolean isAt(Vector2d pos) {
        return this.pos.equals(pos);
    }

    private void moveForwardBackward(MoveDirection movedir, MapDirection direction) {
        Vector2d unitVectorNorth =MapDirection.NORTH.toUnitVector();
        Vector2d unitVectorSouth = MapDirection.SOUTH.toUnitVector();
        Vector2d unitVectorWest = MapDirection.WEST.toUnitVector();
        Vector2d unitVectorEast = MapDirection.EAST.toUnitVector();
        if (movedir == MoveDirection.BACKWARD) {
            unitVectorNorth.opposite();
            unitVectorSouth.opposite();
            unitVectorWest.opposite();
            unitVectorEast.opposite();
        }
        switch (direction) {
            case NORTH -> pos.add(unitVectorNorth);
            case SOUTH -> pos.add(unitVectorSouth);
            case EAST -> pos.add();
            case WEST -> pos.add();
        }
    }

    public void move(MoveDirection direction){
        switch(direction){
            case LEFT ->  this.direction.next();
            case RIGHT -> this.direction.previous();
            case FORWARD ->
            }
        };
    }
}
