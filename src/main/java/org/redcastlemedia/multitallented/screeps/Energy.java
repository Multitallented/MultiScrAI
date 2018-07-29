package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 30/07/15.
 */
@STJSBridge
public class Energy extends ScreepsObject {
    public int energy;
    public String id;
    public RoomPosition pos;
    public Room room;
}
