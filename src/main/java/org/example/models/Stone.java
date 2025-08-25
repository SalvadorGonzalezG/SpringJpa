package org.example.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter

@EqualsAndHashCode
@ToString(callSuper = true)
public abstract class Stone implements Serializable {

   protected String color;
   protected String name;
   protected String location;
   protected Integer energyLevel;
   protected Integer numberOfSides;

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

    public void clear(){
        System.out.println("Cleaning Stone");
    }
}
