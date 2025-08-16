package org.example.factories;

import lombok.extern.java.Log;
import org.example.models.Stone;

import java.util.Optional;

/*
*  Clase abstracta que define una fabrica de "Stone" configurable
* Utiliza el patron factory Method para permitir la creación de diferentes tipos de (Stone*)
* */
@Log
public abstract class ConfigurableStoneFactory {

    // Metodo abstracto que las subclases deberan implemenytar para crear y devolver una instancia concreta de Stone
    public abstract Stone createStone();

    protected boolean isSingleton(){
        final var scopeOpt = Optional.of(System.getProperty("scope"));

        final var scope = scopeOpt.orElse("singleton");

        // Imprime en logs el valor del scope actual
        log.info("scope" + scope);

        // devuelve true si scoppe == "singleton
        return "singleton".equals(scope);
    }
}
