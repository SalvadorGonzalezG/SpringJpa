package org.example.services;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.factories.*;
import org.example.models.*;

import java.lang.reflect.Field;
import java.util.Map;

//@Service
@Log
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class GauntletServiceImp implements IGauntletService {

    private MindStone mind;
    private PowerStone power;
    private RealityStone reality;
    private SoulStone soul;
    private SpaceStone space;
    private TimeStone time;
    //private Object stoneDependency;
/*
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
*/
    // Default Constructor
    public GauntletServiceImp(RealityStone reality, SoulStone soul, PowerStone power, SpaceStone space, TimeStone time, MindStone mind){

    }

    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "mind" -> log.info("Use Stone: " + mind);
            case "power" -> log.info("Use Stone: " + power);
            case "reality" -> log.info("Use Stone: " + reality);
            case "soul" -> log.info("Usse Stone: " + soul);
            case "space" -> log.info("Use stone: " + space);
            case "time" -> log.info("Use Stone: "  + time);
            default ->  throw new IllegalArgumentException("invalid Name");
        }
    }

    @Override
    public void useFullPower(){

        if (this.mind != null && this.power != null
                && this.reality != null && this.soul != null
                && this.space != null && this.time != null){
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
