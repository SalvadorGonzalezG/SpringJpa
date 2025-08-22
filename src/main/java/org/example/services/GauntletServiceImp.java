package org.example.services;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.singletons.MindStoneSingleton;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

//@Service
@Log
//@Setter
//@NoArgsConstructor
public class GauntletServiceImp implements IGauntletService {

    private Stone mindStone;
    private Stone powerStone;
    private Stone reality;
    private Stone soulStone;
    private Stone spaceStone;
    private Stone timeStone;
    private Object stoneDependency;

    public GauntletServiceImp(Stone mindStone, Stone powerStone,
                              Stone reality, Stone soulStone,
                              Stone spaceStone, Stone timeStone){
        this.mindStone = mindStone;
        this.powerStone = powerStone;
        this.reality = reality;
        this.soulStone = soulStone;
        this.spaceStone = spaceStone;
        this.timeStone = timeStone;
    }

    // Default Constructor
    public GauntletServiceImp(){

    }

    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "mind" -> log.info("Use Stone: " + mindStone);
            case "power" -> log.info("Use Stone: " + powerStone);
            case "reality" -> log.info("Use Stone: " + reality);
            case "soul" -> log.info("Usse Stone: " + soulStone);
            case "space" -> log.info("Use stone: " + spaceStone);
            case "time" -> log.info("Use Stone: "  + timeStone);
            default ->  throw new IllegalArgumentException("invalid Name");
        }
    }

    @Override
    public void useFullPower(){

        if (this.mindStone != null && this.powerStone != null
                && this.reality != null && this.soulStone != null
                && this.spaceStone != null && timeStone != null){
            log.info("Use a full POWER of the gauntlet ...");
        } else {
            throw  new IllegalStateException("Cant be using full power because service have fields null ");
        }
    }
    // DI Dependency Injection by fields
    public void setStones(Map<String, Stone>stones){
        stones.forEach((fieldName, stoneDependency) -> {
            try{
                // field hace referencya a cada Stone
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true); // Se aluna el private de forma temporal
                field.set(this, stoneDependency); // Dependency Injection
                log.info("Dependency Injection by Field " + fieldName);
            }catch (NoSuchFieldException | IllegalAccessException e){
                log.warning("Error on DI by fields");

            }
        });
    }
}
