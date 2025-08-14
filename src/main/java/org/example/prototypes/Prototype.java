package org.example.prototypes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.models.*;
/*
* Clase Prototype
* Esta clase implementa el patrón Prorotype para las distintas piedras del infinito.
* Contiene prototipos predefinidos de cada tipo de piedra los cuales permiten
* clonar/copiar instancias usando el metodo getPrototype() definido en cada clase concreta
*
* uso:
* - MindStone copia = Prototype.mindPototype.clone(stoneOriginal);
*
* */
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Evitamos que se creen instancias de esta clase
public class Prototype {

    // Prototype of the mindStone
    public static IStonePrototype<MindStone> mindPrototype =
        stone -> stone.getPrototype();

    public static IStonePrototype<RealityStone> realityPrototype =
            stone -> stone.getPrototype();

    public static IStonePrototype<SoulStone> soulPrototype =
            stone -> stone.getPrototype();

    public static IStonePrototype<PowerStone> powerPrototype =
            stone -> stone.getPrototype();

    public static IStonePrototype<TimeStone> timePrototype =
            stone -> stone.getPrototype();

    public static  IStonePrototype<SpaceStone> spacePrototype =
            stone -> stone.getPrototype();
}
