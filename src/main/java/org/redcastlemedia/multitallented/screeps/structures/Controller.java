package org.redcastlemedia.multitallented.screeps.structures;

import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 30/07/15.
 */
@STJSBridge
public abstract class Controller extends Structure {
    public int level;
    public int progress;
    public int progressTotal;
    public int ticksToDowngrade;
}
