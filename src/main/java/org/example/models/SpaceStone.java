package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
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
        System.out.println("Travel anywhere in the Universe" + super.toString());
    }

    public SpaceStone getPrototype(){
        try(
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos);
                ){
            oos.writeObject(this);
            oos.flush();
            try(final var bis = new ByteArrayInputStream(bos.toByteArray());
                final var ois = new ObjectInputStream(bis);
            ){
                return (SpaceStone) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            log.warning("cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
