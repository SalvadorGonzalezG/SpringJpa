package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class PowerStone extends Stone{

    private static final String COLOR = "Purple";
    private static final String NAME = "Power";
    private static final String LOCATION = "In the ORBE";
    private static final int ENERGY_LAVEL = 6;

    public PowerStone(){
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }
    @Override
    public void usePower(){
        System.out.println("Increment power & Energy " + super.toString());
    }
    public PowerStone getPrototype(){
        try (
                // Flujo de salida de memoria para almacenar bytes
                final var bos = new ByteArrayOutputStream();
                // Flujo para escribir  objetos java serializarlos en el flujo de bytes
                final var oos = new ObjectOutputStream(bos);
                ){
            // Serializa clona el objeto actual
            oos.writeObject(this);
            oos.flush();
            try(
                   final var bis = new ByteArrayInputStream(bos.toByteArray());
                   final var ois = new ObjectInputStream(bis);
                    ){
                // regresa el objeto deserealizado  y lo convierte al tipo PowerStone (clon del original)
                return (PowerStone) ois.readObject();
            }

        }catch (IOException | ClassNotFoundException e){
            log.warning("Cant cast or read to class");
            throw new RuntimeException(e.getMessage());
        }
    }
}
