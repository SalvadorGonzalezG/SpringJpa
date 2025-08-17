package org.example.factories;

import org.example.models.Stone;
import org.example.models.TimeStone;
import org.example.prototypes.Prototype;
import org.example.singletons.TimeStoneSingleton;

public class TimeStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone(){
        if (super.isSingleton()){
            // retorna la unica instancia de PowerStone almacenada en PowerStoneSingleyon
            return TimeStoneSingleton.getInstance();
        } else {
            // clona una nueva instancia basada en TymeStone
            return Prototype.timePrototype.buildStone(new TimeStone());
        }
    }
}
