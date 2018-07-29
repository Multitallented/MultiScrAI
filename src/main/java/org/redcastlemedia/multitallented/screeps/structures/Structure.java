package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.global.StructureTypes;
import org.redcastlemedia.multitallented.screeps.helpers.OwnerProperties;
import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 02/08/15.
 */
@STJSBridge
public abstract class Structure extends ScreepsObject {
    public StructureTypes structureType;
    public int hits = 0;
    public int hitsMax = 0;
    public boolean my = false;
    public OwnerProperties owner = null;

    public abstract int destroy();

    public abstract int notifyWhenAttacked(boolean enabled);
}
