package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback1;
import org.redcastlemedia.multitallented.screeps.global.*;
import org.redcastlemedia.multitallented.screeps.helpers.Targetable;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public class RoomPosition extends Targetable {
    public int x;
    public int y;
    public String roomName;

    /**
     * You can create new RoomPosition object using its constructor.
     *
     * @param x x position in room
     * @param y y position in room
     * @param roomName room name
     */
    public RoomPosition(int x, int y, String roomName) {
        this.x = x;
        this.y = y;
        this.roomName = roomName;
    }

    /**
     * Create new @ConstructionSite at the specified location.
     *
     * @param structureType the structure type
     * @return result
     */
    public ResponseTypes createConstructionSite(StructureTypes structureType) {
        return ResponseTypes.OK;
    }

    /**
     * Create new Flag at the specified location.
     *
     * @param name The name of a new flag. It should be unique, i.e. the Game.flags object
     *             should not contain another flag with the same name (hash key).
     *             If not defined, a random name will be generated.
     * @param color The color of a new flag. The default value is COLOR_WHITE.
     * @return result
     */
    public ResponseTypes createFlag(String name, ColorTypes color) {
        return ResponseTypes.OK;
    }

    /**
     * Find an object with the shortest path from the given position. Uses A* search algorithm and Dijkstra's algorithm.
     *
     * @param type object type
     * @param options parameters for the search
     * @return response
     */
    public ScreepsObject findClosestByRange(FindTypes type, Map<String, Object> options) {
        Room room = Game.rooms.$get(roomName);
        Array<? extends ScreepsObject> findResults = room.find(type, options);
        if (findResults.$length() > 0)
            return findResults.$get(0);
        else
            return null;
    }

    public ScreepsObject findClosestByRange(Array<Targetable> objects, Map<String, Object> options) {
        return null;
    }
    public ScreepsObject findClosestByPath(FindTypes type, Map<String, Object> options) {
        return null;
    }

    public ScreepsObject findClosestByPath(Array<Targetable> objects, Map<String, Object> options) {
        return null;
    }

    public Array<? extends ScreepsObject> findInRange(FindTypes type, int range, Map<String, Object> options) {
        return null;
    }

    public Array<? extends ScreepsObject> findInRange(Array<Targetable> objects, int range, Map<String, Object> options) {
        return null;
    }

    public Array<Map<String, Object>> findPathTo(int x, int y, Map<String, Object> options) {
        return null;
    }

    public Array<Map<String, Object>> findPathTo(Targetable target, Map<String, Object> options) {
        return null;
    }

    public DirectionType getDirectionTo(int x, int y) {
        return null;
    }

    public DirectionType getDirectionTo(Targetable target) {
        return null;
    }

    public int getRangeTo(int x, int y) {
        return 0;
    }

    public int getRangeTo(Targetable target) {
        return 0;
    }

    public boolean inRangeTo(RoomPosition roomPosition, int range) {
        return true;
    }

    public boolean isEqualTo(int x, int y) {
        return true;
    }

    public boolean isEqualTo(Targetable targetable) {
        return true;
    }

    public Array<Map<String, Object>> look() {
        return null;
    }

    public Array<Map<String, Object>> lookFor(String type) {
        return null;
    }

    public static int distance(RoomPosition pos1, RoomPosition pos2) {
        return Math.max(Math.abs(pos1.x - pos2.x), Math.abs(pos1.y - pos2.y));
    }
}
