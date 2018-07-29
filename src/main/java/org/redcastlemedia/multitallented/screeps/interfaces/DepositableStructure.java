package org.redcastlemedia.multitallented.screeps.interfaces;

import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 30/07/15.
 */
@STJSBridge
public abstract class DepositableStructure extends Structure {
    public int energy = 0;
    public int energyCapacity = 0;
}
