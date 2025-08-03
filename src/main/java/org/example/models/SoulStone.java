package org.example.models;

import lombok.ToString;

@ToString
public class SoulStone extends Stone{

    private static final String COLOR = "Naranja";
    private static final String NAME = "Soul";
    private  static  final String LOCATION = "Hidden on vomir";
    private static final int ENERGY_LAVEL = 6;

    public SoulStone(){
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }


    @Override
    public void usePower(){
        System.out.print("Brings the bearer back to life" + super.toString());
    }
}
