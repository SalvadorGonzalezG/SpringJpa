package org.example.factories;

import org.example.models.PowerStone;
import org.example.models.Stone;
import org.example.prototypes.Prototype;
import org.example.singletons.PowerStoneSingleton;

/*
* Fabrica concreta para crear instancias de PowerStone
* Extiende de ConfigurableStoneFactory y decide en tiempo de ejecución si debe de
* entregar una unica instancia (Singleton) o una nueva (protype
* dependiendo del alcance configurado.
* */
public class PowerStoneFactory extends ConfigurableStoneFactory{


    /*
    * Implementacion del metodo abstracto
    *  -Si el alacance es singleton -> retorna siempre la misma instancia.
    *  -Si el alcance es prototype -> crea un nuevo objeto cada vez.
    * */
    @Override
    public Stone createStone(){

        // verifica si el alcance configurado es "singleton"
        // heredamos de la clase padre ConfigurableStoneFactory.
        if (super.isSingleton()){

            //retorna la unica instancia de PowerStone almacenada en PowerStoneSingleton
            return PowerStoneSingleton.getInstance();
        } else {
            // Crea una nueva instancia de PowerSton utiliza el prototipo definido en Prototype.powerPrototype
            // construye (clona un nuevo objeto basado en ese modelo)
            return Prototype.powerPrototype.buildStone(new PowerStone());
        }
    }
}
