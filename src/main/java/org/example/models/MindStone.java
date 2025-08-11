package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true) //manda a llamar el constructor del padre
@Log
public class MindStone extends Stone{

     private final static String COLOR = "AMARILLO";
     private final static String NAME = "MIND";
     private final static String LOCATION = "In the Loki Center";
     private final static int ENERGY_LEVEL = 9;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        // Business Logic
        System.out.print("Mind control in stone" + super.toString());
     }

     public MindStone getPrototype(){
        try(
                // Convert Object into bytes
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos);
                ) {
                // Serialize (clone) object
                oos.writeObject(this);
                oos.flush();
            try(
                    // deseariz
                    final var bis = new ByteArrayInputStream(bos.toByteArray());
                    final var ois = new ObjectInputStream(bis);
                    ) {
                // Cast
                return (MindStone) ois.readObject();
        }
        }catch (IOException | ClassNotFoundException e)

    {
        log.warning("Cant cas or read class");
        throw new RuntimeException(e.getMessage());
        }
     }

}
