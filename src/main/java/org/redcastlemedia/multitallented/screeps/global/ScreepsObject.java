package org.redcastlemedia.multitallented.screeps.global;

import org.redcastlemedia.multitallented.screeps.Room;
import org.redcastlemedia.multitallented.screeps.RoomPosition;
import org.redcastlemedia.multitallented.screeps.helpers.Targetable;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/15.
 */
@STJSBridge
public class ScreepsObject extends Targetable {
    public RoomPosition pos;
    public String id;
    public Room room;
}
