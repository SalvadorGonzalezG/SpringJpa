package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString
@Log
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
        // Business Logic
        System.out.print("Mind control in stone" + super.toString());
     }
     public MindStone getPrototipe(){
        try(
                // Convert object into byte (Serializando)
                final var bos = new ByteArrayOutputStream();
                final var oos = new ObjectOutputStream(bos);
                ){
            // Serialize object (clone) objeto se auto serializa y se auto clona
            oos.writeObject(this);
            oos.flush();
            try(
                    // Deserializando
                    final var bis = new ByteArrayInputStream(bos.toByteArray());
                    final var ois = new ObjectInputStream(bis);
                    ){
                // Cast
                return (MindStone) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            log.warning("Cant cast or read class");
            throw new RuntimeException(e.getMessage());
        }

     }
}
