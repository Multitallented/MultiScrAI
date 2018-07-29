package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public class Source extends ScreepsObject {
    public int energyCapacity;
    public int energy;
    public int ticksToRegeneration;
}
