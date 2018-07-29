package org.redcastlemedia.multitallented.screeps.interfaces;

import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/15.
 */
@STJSBridge
public abstract class DecayableStructure extends Structure {
    public int ticksToDecay = 0;
}
