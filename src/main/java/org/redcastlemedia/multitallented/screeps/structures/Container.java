package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.interfaces.StorableStructure;

public abstract class Container extends StorableStructure {
    public int ticksToDecay = 300;

    public Container() {
        super.storageCapacity = 2000;
    }
}
