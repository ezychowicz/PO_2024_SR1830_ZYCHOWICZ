package agh.ics.oop.model;

public class Animal {
    private MapDirection direction;
    private Vector2d pos;
    private static final Vector2d RIGHT_BOUNDARY_VECTOR = new Vector2d(4,4);
    private static final Vector2d LEFT_BOUNDARY_VECTOR = new Vector2d(0,0);
    public Animal(Vector2d startPosition){
        this.direction = MapDirection.NORTH;
        this.pos = startPosition;
    }

    public Animal() {
        this(new Vector2d(2,2));
    }
    @Override
    public String toString() {
        return "%s|%s".formatted(direction, pos); //%s robi toString na direction i pos (wbudowane toString bedzie uzyte tutaj)
    }
    public boolean isAt(Vector2d pos) {
        return this.pos.equals(pos);
    }

    public MapDirection getDirection() {
        return direction;
    }
    public Vector2d getPos() {
        return pos;
    }

    private void moveForwardBackward(MoveDirection currMoveDirection, MapDirection direction) {
        Vector2d move;
        switch (direction) {
            case NORTH -> move = (currMoveDirection == MoveDirection.FORWARD ? MapDirection.NORTH_UNIT_VECTOR : MapDirection.SOUTH_UNIT_VECTOR);
            case SOUTH -> move = (currMoveDirection == MoveDirection.FORWARD ? MapDirection.SOUTH_UNIT_VECTOR : MapDirection.NORTH_UNIT_VECTOR);
            case EAST -> move = (currMoveDirection == MoveDirection.FORWARD ? MapDirection.EAST_UNIT_VECTOR : MapDirection.WEST_UNIT_VECTOR);
            case WEST -> move = (currMoveDirection == MoveDirection.FORWARD ? MapDirection.WEST_UNIT_VECTOR : MapDirection.EAST_UNIT_VECTOR);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        Vector2d newPosition = pos.add(move);
        if (newPosition.upperRight(RIGHT_BOUNDARY_VECTOR).equals(RIGHT_BOUNDARY_VECTOR) && newPosition.lowerLeft(LEFT_BOUNDARY_VECTOR).equals(LEFT_BOUNDARY_VECTOR) ) {
            pos = newPosition;
        }
    }

    public void move(MoveDirection direction){
        switch(direction) {
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD, BACKWARD -> moveForwardBackward(direction, this.direction);
        };
    }

}
