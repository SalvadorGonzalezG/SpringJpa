package org.example.singletons;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.example.models.MindStone;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) // Generate one Constructor private create one construrtos to the class
public class MindStoneSingleton {

    // Instancia priveniente de Stone Mind in the models MindsStrone class
    private static volatile MindStone mindStone;
}
