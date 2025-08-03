package org.example.models;

import lombok.ToString;

@ToString
public class RealityStone extends Stone{

    private static final String COLOR = "Red";
    private static final String NAME = "Reality";
    private static final String LOCATION = "Asgard";
    private static final int ENERGY_LAVEL = 10;

    public RealityStone(){
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }
    @Override
    public void usePower(){
        System.out.print("Change the Reality completment" + super.toString());
    }
}
