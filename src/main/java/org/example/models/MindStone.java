package org.example.models;

public class MindStone extends Stone{

     private final static String COLOR = "AMARILLO";
     private final static String NAME = "MIND";
     private final static String LOCATION = "In the Loki Center";
     private final static int ENERGY_LAVEL = 9;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }

    @Override
    public void usePower() {

    }
}
