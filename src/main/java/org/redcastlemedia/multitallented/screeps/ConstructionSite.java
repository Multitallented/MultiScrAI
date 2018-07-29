package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 02/08/15.
 */
@STJSBridge
public class ConstructionSite extends ScreepsObject {
    public String id;
    public int progress;
    public int progressTotal;
    public RoomPosition pos;
}
