package org.example.prototypes;

import org.example.models.Stone;

// Interfaz funcional para crear un prototypo (copia de una piedra)
@FunctionalInterface
public interface IStonePrototype<S extends Stone> {

    // Abstract method por defecto
    S buildStone(S stone);
}
