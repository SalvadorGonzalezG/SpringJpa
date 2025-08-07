package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.RealityStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RealityStoneSingleton {

    // Single instance of RealityStone (Single to implement the Singleton pattern )
    private static volatile RealityStone realityStoneInstance;

    // Method to return a instance realityStoncInstance
    public static RealityStone getInstance(){
        if (realityStoneInstance == null){
            log.info("Instance To Reality: " + RealityStoneSingleton.class);
            synchronized (RealityStoneSingleton.class){
                if (realityStoneInstance == null){
                    realityStoneInstance = new RealityStone();
                }
            }
        }
        return realityStoneInstance;
    }
}
