package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.TimeStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeStoneSingleton {
    private static volatile TimeStone timeStoneInstance;

    public static TimeStone getInstance(){
        if (timeStoneInstance == null){
            synchronized (TimeStoneSingleton.class){
                if (timeStoneInstance == null){
                    timeStoneInstance = new TimeStone();
                }
            }
        }
        return timeStoneInstance;
    }
}
