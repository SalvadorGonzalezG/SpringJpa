package org.example.services;

import lombok.extern.java.Log;
import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.singletons.MindStoneSingleton;
import org.springframework.stereotype.Service;

@Service
@Log
public class GauntletServiceImp implements IGauntletService {

    private final Stone mindStone = MindStoneSingleton.getInstance();

    @Override
    public void useGauntlet(String stoneName) {
        log.info("Use Stone: " + mindStone);
    }
}
