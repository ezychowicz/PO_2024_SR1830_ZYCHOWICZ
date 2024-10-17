package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void testParseWithOnlyValidLettersInInput() {
        String[] input = {"f", "f", "b", "f", "l", "l", "r", "l"};

        MoveDirection[] output = OptionsParser.parse(input);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expected, output);
    }
    @Test
    public void testParseWithInvalidLettersInInput() {
        String[] input = {"f", "dada","grdeg","a", "f","2", "b", "l","12131", "r","rtee45", "l"};

        MoveDirection[] output = OptionsParser.parse(input);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expected, output);
    }
    @Test
    public void testParseWithOnlyInvalidInput() {
        String[] input = {"g", "a", "2", "434", "adda", "lflflfllllf", "asd", "wdi"};
        MoveDirection[] output = OptionsParser.parse(input);
        MoveDirection[] expected = new MoveDirection[]{};
        assertArrayEquals(expected, output);
    }
    @Test
    public void testParseWithEmptyInput() {
        String[] input = {};
        MoveDirection[] output = OptionsParser.parse(input);
        MoveDirection[] expected = new MoveDirection[] {};
        assertArrayEquals(expected, output);
    }
    @Test
    public void testParseUpperCaseInput() {
        String[] input = {"L", "R", "L", "R", "F", "B"};
        MoveDirection[] output = OptionsParser.parse(input);
        MoveDirection[] expected = new MoveDirection[] {};
        assertArrayEquals(expected, output);
    }
}
