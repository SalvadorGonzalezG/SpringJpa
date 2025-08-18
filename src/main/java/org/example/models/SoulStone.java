package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
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

    public SoulStone getPrototype(){
        try(
                // Comvert Object into bytes
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos);
                ){
                // Serializando (clone) Object
                    oos.writeObject(this);
                    oos.flush();
                    try(
                            // Deserealizando (clone) objec
                            final var bis = new ByteArrayInputStream(bos.toByteArray());
                            final var ois = new ObjectInputStream(bis);
                            ){
                        // Cast in object
                        return (SoulStone) ois.readObject();
                    }
        }catch (IOException | ClassNotFoundException e){
            log.warning("Cant Cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }

}
