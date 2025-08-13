package org.example.prototypes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.models.MindStone;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Prototype {

    public static IStonePrototype<MindStone> mindPrototype =
        stone -> stone.getPrototype();
}
