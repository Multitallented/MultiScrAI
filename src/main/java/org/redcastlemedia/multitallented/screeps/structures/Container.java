package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.interfaces.StorableStructure;
import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge
public abstract class Container extends StorableStructure {
    public int ticksToDecay = 300;

    public Container() {
        super.storageCapacity = 2000;
    }
}
