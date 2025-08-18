package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@Log
@ToString(callSuper = true)
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
    public RealityStone getPrototype(){
        try(
                // Convert object into bytes
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos);
                ){
            // Serialize, object clone
            oos.writeObject(this);
            oos.flush();
            try(
                    final var bis = new ByteArrayInputStream(bos.toByteArray());
                    final var ois = new ObjectInputStream(bis);
                    ){
                return (RealityStone) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
