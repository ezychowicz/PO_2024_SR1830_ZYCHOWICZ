package agh.ics.oop.model;
import java.util.Objects;
public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }
    public boolean precedes(Vector2d other) {
        return x <= other.x && y <= other.y;
    }
    public boolean follows(Vector2d other) {
        return x >= other.x && y >= other.y;
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }
    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(other.x, x), Math.max(other.y, y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(other.x, x), Math.min(other.y, y));
    }
    public Vector2d opposite(){
        return new Vector2d(-x, -y);
    }
    @Override
    public boolean equals(Object other) {
//        if (other instanceof Vector2d otherVector) {
//            return x == otherVector.x && y == otherVector.y;
//        }
//        return false;
        if (this == other) return true;  //z wykladu
        if (!(other instanceof Vector2d vector2d))
            return false;
        return x == vector2d.x && y == vector2d.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y); //bardzo spowalnia, szybciej by bylo:
//        int result = 17;
//        result = 31 * result + x;
//        result = 31 * result + y;
//        return result;
    }
}

