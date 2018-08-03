package org.redcastlemedia.multitallented.multiscrai.screeps;

import org.redcastlemedia.multitallented.screeps.Room;
import org.redcastlemedia.multitallented.screeps.RoomPosition;
import org.redcastlemedia.multitallented.screeps.global.*;
import org.redcastlemedia.multitallented.screeps.helpers.Targetable;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;


public class RoomImpl extends Room {

    public RoomImpl(String name, Map<String, Object> memory) {
        super.name = name;
        super.memory = memory;
        this.controller = new ControllerImpl();
        this.controller.pos = new RoomPosition(30, 30, name);
    }

    @Override
    public ResponseTypes createConstructionSite(int x, int y, StructureTypes type) {
        return null;
    }

    @Override
    public ResponseTypes createConstructionSite(RoomPosition position, StructureTypes type) {
        return null;
    }

    @Override
    public ResponseTypes createFlag(int x, int y, String name, ColorTypes color) {
        return null;
    }

    @Override
    public ResponseTypes createFlag(RoomPosition position, String name, ColorTypes color) {
        return null;
    }

    @Override
    public Array<? extends ScreepsObject> find(FindTypes type, Map<String, Object> options) {
        if (type == FindTypes.FIND_CREEPS) {
            return super.creeps;
        } else if (type == FindTypes.FIND_STRUCTURES) {
            return super.structures;
        } else if (type == FindTypes.FIND_SOURCES) {
            return super.sources;
        }
        return null;
    }

    @Override
    public RoomDirectionTypes findExitTo(Room room) {
        return null;
    }

    @Override
    public RoomDirectionTypes findExitTo(String roomName) {
        return null;
    }

    @Override
    public Array<Map<String, Object>> findPath(RoomPosition fromPos, RoomPosition toPos, Map<String, Object> options) {
        return null;
    }

    @Override
    public RoomPosition getPositionAt(int x, int y) {
        return null;
    }

    @Override
    public Array<Map<String, Object>> lookAt(int x, int y) {
        return null;
    }

    @Override
    public Array<Map<String, Object>> lookAt(Targetable targetable) {
        return null;
    }

    @Override
    public Array<Map<String, Object>> lookAtArea(int top, int left, int bottom, int right) {
        return null;
    }

    @Override
    public Array<? extends ScreepsObject> lookForAt(String type, int x, int y) {
        return null;
    }

    @Override
    public Array<? extends ScreepsObject> lookForAt(String type, Targetable targetable) {
        return null;
    }

    @Override
    public Map<String, Map<String, Object>> lookForAtArea(String type, int top, int left, int bottom, int right) {
        return null;
    }
}
