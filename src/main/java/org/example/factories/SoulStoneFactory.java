package org.example.factories;

import org.example.models.SoulStone;
import org.example.models.Stone;
import org.example.prototypes.Prototype;
import org.example.singletons.SoulStoneSingleton;

public class SoulStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone() {

        if (super.isSingleton()){
            // Regresa la unica intancia de SoulStone almacenada en SoulStonSingleton
            return SoulStoneSingleton.getInstance();
        } else {
            //Clona una nueva instancia basada en SoulStone
         return Prototype.soulPrototype.buildStone(new SoulStone());
        }
    }
}
