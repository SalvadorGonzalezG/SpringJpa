package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import lombok.extern.java.Log;
import org.example.models.SpaceStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpaceStoneSingleton {

    private static volatile SpaceStone spaceStoneInstance;

    public static SpaceStone getInstance(){
        if (spaceStoneInstance == null) {
            synchronized (SpaceStoneSingleton.class) {
                if (spaceStoneInstance == null) {
                    spaceStoneInstance = new SpaceStone();
                }
            }
        }
        return  spaceStoneInstance;
    }
}
