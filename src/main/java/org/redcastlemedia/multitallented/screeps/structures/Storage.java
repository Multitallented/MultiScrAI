package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.interfaces.StorableStructure;

/**
 * Created by nick on 10/08/15.
 */
public abstract class Storage extends StorableStructure {
    public Storage() {
        super.storageCapacity = 10000;
    }
}
