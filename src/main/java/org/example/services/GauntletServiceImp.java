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

    private  Stone mindStone;
    private Stone reality;

    // Default Constructor
    public GauntletServiceImp(){

    }

    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "reality" -> log.info("Use Stone: " + reality);

            default ->  throw new IllegalArgumentException("invalid Name");
        }
    }

    @Override
    public void useFullPower(){

    }
}
