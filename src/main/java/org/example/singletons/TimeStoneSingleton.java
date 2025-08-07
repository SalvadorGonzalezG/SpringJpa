package org.example.singletons;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.TimeStone;

@Log
@NoArgsConstructor
public class TimeStoneSingleton {
    private static volatile TimeStone timeStoneInstance;

    public static TimeStone getInstance(){
        if (timeStoneInstance == null){
            log.info("Create Instance TimeStone: " + TimeStoneSingleton.class);
            synchronized (TimeStoneSingleton.class){
                if (timeStoneInstance == null){
                    timeStoneInstance = new TimeStone();
                }
            }
        }
        return timeStoneInstance;
    }
}
