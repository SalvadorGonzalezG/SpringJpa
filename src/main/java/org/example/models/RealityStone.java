package org.example.models;

import lombok.ToString;

@ToString
public class RealityStone extends Stone{

    private static final String COLOR = "";
    private static final String NAME = "";
    private static final String LOCATION = "";
    private static final int ENERGY_LAVEL = 10;

    public RealityStone(){
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }
    @Override
    public void usePower(){
        System.out.print("Change the Reality completment" + this.toString());
    }
}
