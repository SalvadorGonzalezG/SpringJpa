package org.example.configs;

import org.example.services.IGauntletService;

import java.util.function.Consumer;

// Inversion del control IoC
public class StoneContext {

    public IGauntletService setContext(
            Consumer<Void> preConstruct,
            Consumer<Void>  postConstruct
    )
}
