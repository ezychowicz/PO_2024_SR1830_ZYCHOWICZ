package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Vector2d> initialPositions;
    private final List<MoveDirection> moves;
    private final List<Animal> animalsList;
    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves) {
        this.initialPositions = initialPositions;
        this.moves = moves;
        this.animalsList = createAnimalsList();
    }

    public List<Animal> getAnimalsList() {
        return animalsList;
    }



    private List<Animal> createAnimalsList() {
        List<Animal> animalsList = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            animalsList.add(new Animal(position));
        }
        return animalsList;
    }
    public void run(){
        int animalsIndex;
        for (int i = 0; i < moves.size(); i++) {
            animalsIndex = i % animalsList.size();
            animalsList.get(animalsIndex).move(moves.get(i));
            System.out.printf("Zwierze %d : %s%n", animalsIndex, animalsList.get(animalsIndex).toString().split("\\|")[1]);
        }
    }
}
