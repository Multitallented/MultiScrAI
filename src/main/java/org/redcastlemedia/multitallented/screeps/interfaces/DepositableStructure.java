package org.redcastlemedia.multitallented.screeps.interfaces;

import org.redcastlemedia.multitallented.screeps.Creep;
import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.structures.Structure;

/**
 * Created by nick on 30/07/15.
 */
public abstract class DepositableStructure extends Structure {
    public int energy = 0;
    public int energyCapacity = 0;

    public abstract ResponseTypes transferEnergy(Creep creep, int amount);
}