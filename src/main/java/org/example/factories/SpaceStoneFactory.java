package org.example.factories;

import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.prototypes.Prototype;
import org.example.singletons.RealityStoneSingleton;
import org.example.singletons.SpaceStoneSingleton;

public class SpaceStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone(){
        if (super.isSingleton()){
            // Regresa la unica instancia de RealityStone almacenada en RealityStoneSingleton
            return SpaceStoneSingleton.getInstance();
        } else {
            // clona una nueva instancia basada en RealityStone
            return Prototype.realityPrototype.buildStone(new RealityStone());
        }
    }
}
