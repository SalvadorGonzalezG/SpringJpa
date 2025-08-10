package org.example;

import org.example.models.MindStone;
import org.example.models.PowerStone;
import org.example.models.RealityStone;
import org.example.models.Stone;
import org.example.services.GauntletServiceImp;
import org.example.singletons.MindStoneSingleton;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final var mind = new MindStone();
        final var power = new PowerStone();
        final var reality = new RealityStone();

        mind.usePower();
        System.out.println("-");

        power.usePower();
        System.out.println("--");

        reality.usePower();
        System.out.println("---");

        // Instance 1
        final var gauntletService = new GauntletServiceImp();
        gauntletService.useGauntlet("");

        var instance2 = MindStoneSingleton.getInstance();

        System.out.println(instance2);
        /*
        var r1 = MindStoneSingleton.getInstance();
        var r2 = MindStoneSingleton.getInstance();

        if ( r1 == r2){
            System.out.println("Singleton");
        }*/

        // instance1 prototipe
        final var mindS = new MindStone();

        System.out.println(mindS);
        System.out.println(System.identityHashCode(mindS));
        System.out.println(System.identityHashCode(mind));

        // instance2 prototype clone
        final var mindProto = mindS.getPrototype();
        System.out.println(System.identityHashCode(mindProto));

    }
}