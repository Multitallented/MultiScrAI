package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.helpers.Targetable;
import org.redcastlemedia.multitallented.screeps.structures.Controller;
import org.redcastlemedia.multitallented.screeps.structures.Storage;
import org.redcastlemedia.multitallented.screeps.global.*;
import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public abstract class Room {
    public Array<Creep> creeps = new Array<>();
    public Array<Structure> structures = new Array<>();
    public Array<Source> sources = new Array<>();

    public String name;
    public Map<String, Object> memory;
    public Controller controller;
    public int energyAvailable;
    public int energyCapacityAvailable;
    public ModeTypes mode;
    private Storage storage;

    public abstract ResponseTypes createConstructionSite(int x, int y, StructureTypes type);

    public abstract ResponseTypes createConstructionSite(RoomPosition position, StructureTypes type);

    public abstract ResponseTypes createFlag(int x, int y, String name, ColorTypes color);

    public abstract ResponseTypes createFlag(RoomPosition position, String name, ColorTypes color);

    public abstract Array<? extends ScreepsObject> find(FindTypes type, Map<String, Object> options);

    public abstract RoomDirectionTypes findExitTo(Room room);

    public abstract RoomDirectionTypes findExitTo(String roomName);

    public abstract Array<Map<String, Object>>  findPath(RoomPosition fromPos, RoomPosition toPos, Map<String, Object> options);

    public abstract RoomPosition getPositionAt(int x, int y);

    public abstract Array<Map<String, Object>> lookAt(int x, int y);

    public abstract Array<Map<String, Object>> lookAt(Targetable targetable);

    public abstract Array<Map<String, Object>> lookAtArea(int top, int left, int bottom, int right);

    public abstract Array<? extends ScreepsObject> lookForAt(String type, int x, int y);

    public abstract Array<? extends ScreepsObject> lookForAt(String type, Targetable targetable);

    public abstract Map<String, Map<String, Object>> lookForAtArea(String type, int top, int left, int bottom, int right);
}
