package agh.ics.oop.model;

//Podstawowym atrybutem klasy RectangularMap powinna być struktura przechowująca zwierzęta
// na ich pozycjach. Do realizacji takiego odwzorowania wykorzystaj mapę (słownik).
// Z każdą aktualną pozycją zwierzęcia (Vector2d) powiążesz obiekt Animal.
// Deklaracja typu takiego atrybutu powinna wyglądać tak: Map<Vector2d, Animal> animals = new HashMap<>();.
//
//Uzupełnij brakującą logikę w RectangularMap zgodnie z wytycznymi:
//
//definiuje prostokątną mapę - posiada szerokość oraz wysokość,
//
//implementuje interfejs WorldMap,
//
//w konstruktorze akceptuje dwa parametry width oraz height wskazujące szerokość oraz wysokość mapy (możesz założyć że otrzymane wartości są poprawne),
//
//umożliwia poruszanie się w obrębie zdefiniowanego prostokąta (jak w laboratorium 3),
//
//umożliwia występowanie więcej niż jednego zwierzęcia na mapie,
//
//uniemożliwia występowanie więcej niż jednego zwierzęcia na tej samej pozycji,
//
//posiada metodę toString rysującą aktualną konfigurację mapy (wykorzystaj klasę MapVisualizer, która znajduje się w tym katalogu).
//
//Pamiętaj by zaimplementować wszystkie metody narzucone przez interfejs!

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d upperRightBoundary;
    private final Vector2d lowerLeftBoundary;
    public RectangularMap(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.upperRightBoundary = new Vector2d(this.width, this.height);
        this.lowerLeftBoundary = new Vector2d(0,0);
    }

    @Override
    public boolean place(Animal animal) {

        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
    //mechanizm poruszania moze juz gdzies mam?
        if (!animals.containsValue(animal) || !canMoveTo()
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return isOccupied(position) ? animals.get(position): null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && !isOnMap(position);

    }

    public boolean isOnMap(Vector2d position) {
        return position.precedes(upperRightBoundary) && position.follows(lowerLeftBoundary);
    }
}
