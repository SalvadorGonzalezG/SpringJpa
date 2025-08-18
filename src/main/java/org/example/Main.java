package org.example;

import org.example.factories.PowerStoneFactory;
import org.example.factories.RealityStoneFactory;
import org.example.factories.TimeStoneFactory;
import org.example.models.*;
import org.example.prototypes.Prototype;
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
        //final var gauntletService = new GauntletServiceImp();
        //gauntletService.useGauntlet("");

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

        //instance 4 spaceStone Prototype
        final var spaceStonePrototype1 = new SpaceStone();
        System.out.println(System.identityHashCode(spaceStonePrototype1) + " spaceStone");

        final var soulStoneProto = new SoulStone();
        System.out.println(System.identityHashCode(soulStoneProto) + " SoulStone");

        final var realityStone = new RealityStone();
        System.out.println(System.identityHashCode(realityStone) + " RealityStone");


        final var mindP = new MindStone();

        final var mindProtos = Prototype.mindPrototype.buildStone(mindP);
        System.out.println(System.identityHashCode(mindProtos) + " Prototypo MindStone");

        final var realityP = new RealityStone();
        final var realiteProto = Prototype.realityPrototype.buildStone(realityP);
        System.out.println(System.identityHashCode(realiteProto) + " RealityStone Prototype");

        //Use Factory Method
        System.setProperty("scope", "singleton");

        final var timeStoneFactory = new TimeStoneFactory();
        var timeStone = timeStoneFactory.createStone();

        System.out.println(timeStone + " Factory");

        final var powerStonefactory = new PowerStoneFactory();
        var powerStone = powerStonefactory.createStone();

        System.out.println(powerStone + " Factory");

        var realityFactory = new RealityStoneFactory();

        final var gauntletSer = new GauntletServiceImp();
        gauntletSer.setReality(realityFactory.createStone());
        gauntletSer.useGauntlet("reality");


    }
}