package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
//        MoveDirection[] parsedInput = OptionsParser.parse(args);
//        run(parsedInput);
        Animal animal = new Animal();
        System.out.println(animal.toString());
        System.out.println("system zakończył działanie");
    }
    public static void run(MoveDirection[] input){
        for (MoveDirection arg : input) {
            switch (arg) {
                case MoveDirection.FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case MoveDirection.BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case MoveDirection.RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case MoveDirection.LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
}
