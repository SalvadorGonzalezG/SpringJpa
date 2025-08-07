package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.PowerStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PowerStoneSingleton {

    private static volatile PowerStone powerStoneInstance;

    public static  PowerStone getInstance(){
        if (powerStoneInstance == null){
            log.info("Instance POWERSTONE: " + PowerStoneSingleton.class);
            synchronized (PowerStoneSingleton.class){
                if (powerStoneInstance == null){
                    powerStoneInstance = new PowerStone();
                }
            }
        }
        return powerStoneInstance;
    }
}
