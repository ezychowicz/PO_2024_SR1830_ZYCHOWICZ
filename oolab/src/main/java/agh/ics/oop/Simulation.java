package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    public static final String ANIMAL_STRING = "Zwierze";
    private final List<Vector2d> positions;
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap worldMap) {
        this.positions = new ArrayList<>(positions); //zeby dało sie usuwać
        this.moves = moves;
        this.worldMap = worldMap;
        fillWorldMap();
    }

    private void fillWorldMap() {
        List<Integer> indicesToRemove = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            Vector2d position = positions.get(i);
            Animal animal = new Animal(position);
            if (!worldMap.place(animal)) {  // jeśli nie udało się umieścić, dodaj indeks do usunięcia
                indicesToRemove.add(i);
            }
        }
        indicesToRemove.sort(Collections.reverseOrder());
        for (int idx : indicesToRemove) {
            positions.remove(idx);
        }
    }
    public WorldMap getWorldMap() {
        return worldMap;
    }

    public List<Vector2d> getPositions() {
        return positions;
    }

    public void run(){
        int animalsIndex;
        Vector2d currPos;
        for (int i = 0; i < moves.size(); i++) {
            animalsIndex = i % positions.size();
            currPos = positions.get(animalsIndex); //pozycja zwierzaka, którego bedziemy chcieli przenieść
            WorldElement animalAtCurrPos = worldMap.objectAt(currPos);
            worldMap.move((Animal) animalAtCurrPos, moves.get(i)); //próba przeniesienia
            positions.set(animalsIndex, animalAtCurrPos.getPos()); //zaktualizuj pozycje
            System.out.println(worldMap);
        }
    }
}
