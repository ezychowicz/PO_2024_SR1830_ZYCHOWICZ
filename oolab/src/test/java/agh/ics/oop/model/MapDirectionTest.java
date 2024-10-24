package agh.ics.oop.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MapDirectionTest {
    @Test
    public void nextAllDirections() {
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }
    @Test
    public void previousAllDirections() {
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }
}
