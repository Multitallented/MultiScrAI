package org.redcastlemedia.multitallented.screeps.interfaces;

import org.redcastlemedia.multitallented.screeps.helpers.Store;
import org.redcastlemedia.multitallented.screeps.structures.Structure;

public abstract class StorableStructure extends Structure {
    public Store store = new Store();
    public int storageCapacity = 0;
}
