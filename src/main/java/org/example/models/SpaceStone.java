package org.example.models;

public class SpaceStone extends Stone{

// A Static property belongs to the class and not to the Objetc
    private static final String COLOR = "BLUE";
    private static final String NAME = "Space";
    private static final String LOCATION = "In the Teseracto";
    private static final int ENERGY_LAVEL = 8;


    public SpaceStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }

    @Override
    public void usePower(){
        System.out.println("");
    }
}
