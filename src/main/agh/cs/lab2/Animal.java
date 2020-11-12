package agh.cs.lab2;

import agh.cs.lab2.utility.*;

public class Animal extends AbstractMapElement {
    public Animal() {   // czy ten konstruktor jest bezpieczny?
        super(new Vector2d(2,2));
        this.mapDirection = MapDirection.NORTH;
        this.worldMap = null;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.mapDirection = MapDirection.NORTH;
        if (map.place(this))
            this.worldMap = map;
        else
            throw new IllegalArgumentException("Cannot place animal on that position");
    }

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2,2));
    }



    public void move(MoveDirection direction) {
        MapDirection newMapDirection = mapDirection.getRelativeDirection(direction);

        if(direction == MoveDirection.FORWARD || direction == MoveDirection.BACKWARD) {
            Vector2d newPosition = position.add(newMapDirection.toUnitVector());
            if(worldMap != null && !worldMap.canMoveTo(newPosition))
                return;
            position = newPosition;
        }

        if (direction != MoveDirection.BACKWARD)
            mapDirection = newMapDirection;
    }

    @Override
    protected String stringRepresentation() {
        switch (this.mapDirection) {
            case WEST: return "<";
            case EAST: return ">";
            case SOUTH: return "v";
            case NORTH: default: return "^";
        }
    }

    private MapDirection mapDirection;
    private final IWorldMap worldMap;
}
