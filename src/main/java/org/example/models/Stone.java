package org.example.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Stone {

    String color;
    String name;
    String location;
    Integer energyLevel;
    Integer numberOfSides;

    private static final int NUMBER_SIDES = 6;
    // Constructor
    public Stone(String color,
                 String name,
                 String location,
                 Integer energyLavel){
        this.color = color;
        this.name = name;
        this.location = location;
        this.energyLevel = energyLavel;
        this.numberOfSides = NUMBER_SIDES;
    }

    public abstract void usePower();

}
