package org.example.factories;

import org.example.models.MindStone;
import org.example.models.Stone;
import org.example.prototypes.Prototype;
import org.example.singletons.MindStoneSingleton;

public class MindStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone(){
        if (super.isSingleton()){

            // Regresa la unica instancia de MindStone almacenada en MindStoneSingleton
            return MindStoneSingleton.getInstance();
        }else{
            // clona una nueva instancia de MindStone.
            return Prototype.mindPrototype.buildStone(new MindStone());
        }
    }
}
