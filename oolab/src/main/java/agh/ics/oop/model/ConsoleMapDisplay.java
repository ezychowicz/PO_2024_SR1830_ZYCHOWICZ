package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private static final String UPDATE_STRING = "Update";
    private static final String COUNT_STRING = "count";
    private int updateCnt = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCnt++;
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("%s %s: %d\n\n".formatted(UPDATE_STRING, COUNT_STRING, updateCnt));
    }
}
