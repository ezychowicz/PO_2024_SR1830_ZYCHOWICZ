package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTestVectorWithItself() {
        Vector2d v1 = new Vector2d(1,2);
        assertEquals(v1, v1, "vector is equal to itself");
    }
    @Test
    public void equalsTestSameVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(true, v1.equals(v2), "vectors with same cords are equal");

        Vector2d v3 = new Vector2d(1000,2000);
        Vector2d v4 = new Vector2d(1000,2000);
        assertEquals(true, v3.equals(v4),"vectors with same values cords are equal");
    }
    @Test
    public void equalsTestDifferentVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(false, v1.equals(v2),"vectors with different values cords are not equal");
        Vector2d v3 = new Vector2d(2,2000);
        Vector2d v4 = new Vector2d(8,2000);
        assertEquals(false, v3.equals(v4), "vectors with different values cords are not equal");
    }
    @Test
    public void equalsTestNull() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = null;
        assertEquals(false, v1.equals(v2), "not null vector is not equal null");
    }
    @Test
    public void equalsTestDifferentObject() {
        Vector2d v1 = new Vector2d(1,2);
        Object v2 = new Object();
        assertEquals(false, v1.equals(v2), "non Vector2d class object is not equal to Vector2d object");
        String notVector2d = "nonvector2dtype";
        assertEquals(false, v1.equals(notVector2d), "non Vector2d class object is not equal to Vector2d object");
    }
    @Test
    public void toStringTest() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals("(1, 2)", v1.toString(), "toString() method returns an incorrect string");
        assertEquals("(1000, 2000)", v2.toString(), "toString() method returns an incorrect string");
    }
    @Test
    public void precedesTestDifferentVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(true, v1.precedes(v2), "v1 precedes v2, as both cords are lower");
        assertEquals(false, v2.precedes(v1), "v2 does not precede v1, as both of its cords are higher");

        Vector2d v3 = new Vector2d(1,2);
        Vector2d v4 = new Vector2d(1,2000);
        assertEquals(true, v3.precedes(v4), "v3 precedes v4, as x cord is equal and y cord is lower");
        assertEquals(false, v4.precedes(v3), "v4 y cord is higher than x cord, thus v4 does not precede v3");
    }
    @Test
    public void precedesTestEqualVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(true, v1.precedes(v2),"v1 precedes v2, as both cords are equal");
    }
    @Test
    public void followsTestEqualVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertTrue(v2.follows(v1), "v2 follows v1, as both cords are equal");
    }
    @Test
    public void followsTestDifferentVectors() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertTrue(v2.follows(v1), "v2 follows v1, as both cords are higher");
        assertFalse(v1.follows(v2), "v1 does not follow v2, as both of its cords are lower");

        Vector2d v3 = new Vector2d(1,2);
        Vector2d v4 = new Vector2d(1,2000);
        assertTrue(v4.follows(v3), "v4 follows v3, as x cord is equal and y cord is higher");
        assertFalse(v3.follows(v4), "v3 y cord is lower than v4 y cord, thus v3 does not follow v4");
    }
    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(new Vector2d(1000,2000), v1.upperRight(v2));
        assertEquals(new Vector2d(1000,2000), v2.upperRight(v1));

        Vector2d v3 = new Vector2d(0,3);
        assertEquals(new Vector2d(1,3), v1.upperRight(v3));
        assertEquals(new Vector2d(1,3), v3.upperRight(v1));
    }
    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(new Vector2d(1,2), v1.lowerLeft(v2));
        assertEquals(new Vector2d(1,2), v2.lowerLeft(v1));
        Vector2d v3 = new Vector2d(0,3);
        assertEquals(new Vector2d(0,2), v1.lowerLeft(v3));
        assertEquals(new Vector2d(0,2), v3.lowerLeft(v1));
    }
    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(new Vector2d(1001,2002), v1.add(v2));
    }
    @Test
    public void subtractTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1000,2000);
        assertEquals(new Vector2d(-999,-1998), v1.subtract(v2));
    }
    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(1,2);
        assertEquals(new Vector2d(-1,-2), v1.opposite());
    }
}
