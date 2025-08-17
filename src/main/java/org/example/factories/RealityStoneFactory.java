package org.example.factories;

import lombok.extern.java.Log;
import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.prototypes.Prototype;
import org.example.singletons.RealityStoneSingleton;

@Log
public class RealityStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone(){

        // Verifica si el alcance configurado es singleton
        if (super.isSingleton()){
            // regresa la unica instancia de RealityStone almacenada en RealityStoneSingleton
            return RealityStoneSingleton.getInstance();
        }else {
            // crea una nueva instancia de RealityStone utiliza el proto definido en Protorype.RealityPrototype
            // // clona un nuevo objeto basado en RealityStone
            return Prototype.realityPrototype.buildStone(new RealityStone());
        }
    }
}
