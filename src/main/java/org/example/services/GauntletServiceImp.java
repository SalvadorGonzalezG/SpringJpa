package org.example.services;

import lombok.Setter;
import lombok.extern.java.Log;
import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.singletons.MindStoneSingleton;
import org.springframework.stereotype.Service;

@Service
@Log
@Setter
public class GauntletServiceImp implements IGauntletService {

    private Stone mindStone;
    private Stone powerStone;
    private Stone reality;
    private Stone soulStone;
    private Stone spaceStone;
    private Stone timeStone;

    // Default Constructor
    public GauntletServiceImp(){

    }

    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "mindStone" -> log.info("Use Stone: " + mindStone);
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
}
