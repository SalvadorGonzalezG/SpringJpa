package org.example.configs;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.factories.*;
import org.example.models.*;
import org.example.services.GauntletServiceImp;
import org.example.services.IGauntletService;

import java.util.Map;
import java.util.function.Consumer;

// Inversion del control IoC
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoneContext {

    public static IGauntletService setContext(
            // funcional interfaces
            Consumer<Void> preConstruct,
            Consumer<Void> postConstruct
    ) {
        //Get Sco´pe
        log.info("IoC set Scope");
        System.setProperty("scope", "singleton");

        //@Preconstruct
        log.info("LoC excecuting preConstruct");
        preConstruct.accept(null);
        //Create factories to use  Dependency Injection by Constructor
        //Inversion de control
        log.info("LoC creationg factories");
        var mindFactory = new MindStoneFactory();
        var powerFactory = new PowerStoneFactory();
        var realityFactory = new RealityStoneFactory();
        var soulFactory = new SoulStoneFactory();
        var spaceFactory = new SpaceStoneFactory();
        var timeFactory = new TimeStoneFactory();

        log.info("LoC Instance Objects");
        MindStone mind = (MindStone) mindFactory.createStone();
        PowerStone power = (PowerStone) powerFactory.createStone();
        RealityStone reality = (RealityStone) realityFactory.createStone();
        SoulStone soul = (SoulStone) soulFactory.createStone();
        SpaceStone space = (SpaceStone) spaceFactory.createStone();
        TimeStone time = (TimeStone) timeFactory.createStone();

        log.info("loC loading GauntletServicesImp in container");
        final var gauntletService = new GauntletServiceImp();

        Map<String, Stone> instances = Map.of(
                "reality", reality,
                "soul", soul,
                "power", power,
                "space", space,
                "time", time,
                "mind", mind

        );
        log.info("loC Di on GauntletServiceImp");
        gauntletService.setStones(instances);
        //@PostConstruct
        log.info("loC excecuting postConstruct");
        postConstruct.accept(null);

        return gauntletService;
    }

    // Clean the context
    public static void destroyContext(
            IGauntletService iGauntletService
    ){
        log.info("Cleaning context");
        if(iGauntletService instanceof GauntletServiceImp){
            ((GauntletServiceImp) iGauntletService).getMind().clear();
            ((GauntletServiceImp) iGauntletService).getTime().clear();
            ((GauntletServiceImp) iGauntletService).getSoul().clear();
            ((GauntletServiceImp) iGauntletService).getReality().clear();
            ((GauntletServiceImp) iGauntletService).getSpace().clear();
            ((GauntletServiceImp) iGauntletService).getPower().clear();


        }
        // destrucción del contexto
        log.info("Cleaning Properties");
        System.clearProperty("scope");
    }
}
