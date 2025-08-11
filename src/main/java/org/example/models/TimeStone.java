package org.example.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class TimeStone extends Stone{

    private static final String COLOR = "Green";
    private static final String NAME = "Time";
    private static final String LOCATION = "In the EYE of Agamotto";
    private static final int ENERGY_LAVEL = 3;

    public TimeStone(){
        super(COLOR, NAME, LOCATION, ENERGY_LAVEL);
    }

    @Override
    public void usePower(){
        System.out.println("Stop or Speed up Time" + this.toString());
    }

    public TimeStone getPrototype(){
        try (
                // crea flujo de salida de memoria para almacenar Bytes
                final var bos = new ByteArrayOutputStream();
                // Crea un flujo para escribir objetos Java (Serializarlos) en el flujo de bytes
                final var oos = new ObjectOutputStream(bos);
                ){
                // Serializa (Convierte a bytes) el objeto actual
                oos.writeObject(this);
                // Fuerza a que todos los datos pendientes se escriban en e flujo
                oos.flush();

                try(
                        // Crea un flujo de entrada en memoria apartir de los bytes serializados
                        final var bis = new ByteArrayInputStream(bos.toByteArray());
                        // Crea un flujo para leer objetos java (deserializarlos desde el flujo de entrada)
                        final var ois = new ObjectInputStream(bis);
                        ){
                    // Regresa el objeto deserealizado y lo convierte al tipo TimeStone ( Clon del original )
                    return (TimeStone) ois.readObject();
                }

        }catch (IOException | ClassNotFoundException e){
            log.warning("Cant Cast or read class");
            throw new RuntimeException(e.getMessage());

        }

    }
}
