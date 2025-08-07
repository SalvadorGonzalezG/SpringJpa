package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.SoulStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SoulStoneSingleton {

    private static volatile SoulStone soulStoneInstance;

    public static SoulStone getInstance(){
        if (soulStoneInstance == null){
            log.info("Create instance to SoulStone: " +  SoulStoneSingleton.class);
            synchronized (SoulStoneSingleton.class){
                if (soulStoneInstance == null){
                    soulStoneInstance = new SoulStone();
                }
            }
        }
        return soulStoneInstance;
    }
}
