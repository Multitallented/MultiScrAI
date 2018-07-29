package org.redcastlemedia.multitallented.multiscrai.Controllers;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback;
import org.redcastlemedia.multitallented.helpers.LodashCallback1;
import org.redcastlemedia.multitallented.helpers.LodashCallback2;
import org.redcastlemedia.multitallented.multiscrai.roles.CreepRole;
import org.redcastlemedia.multitallented.multiscrai.roles.Upgrader;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepUtil;
import org.redcastlemedia.multitallented.screeps.*;
import org.redcastlemedia.multitallented.screeps.global.FindTypes;
import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

/**
 * Created by nick on 26/07/15.
 */
public class RoomController {

    private final RoomController roomController;
    // room globals
    public boolean hasPathFound = false;

    private Room room;
    private Map<String, Object> cpuMemory;
    private float cpu = 0;

    public RoomController(Room room) {
        this.room = room;
        this.roomController = this;

        // Check if memory is defined
        if (this.room.memory.$get("created") == null) {
            this.room.memory.$put("created", true);
        }
        this.cpuMemory = getMemory("cpuMemory");
    }

    private Object getMemoryOrDefault(String key, Object value) {
        Object check = this.room.memory.$get(key);
        if (check == null) {
            check = value;
        }
        return check;
    }

    private void putMemory(String key, Object value) {
        this.room.memory.$put(key, value);
    }

    public void step() {
        Array<Creep> creeps = (Array<Creep>) room.find(FindTypes.FIND_CREEPS, JSCollections.$map());
        Lodash.forIn(creeps, new LodashCallback1<Creep>() {

            @Override
            public boolean invoke(Creep creep) {
                CreepUtil.runByRole(creep, roomController);
                return false;
            }
        }, this);


//
//        Array<Structure> structures = (Array<Structure>) room.find(FindTypes.FIND_STRUCTURES, JSCollections.$map());

        //TODO add room logic
    }

    public Source getAvailableHarvest(RoomPosition roomPosition, boolean reserve) {
        Source source = (Source) roomPosition.findClosestByRange(FindTypes.FIND_SOURCES, JSCollections.$map());
        //TODO add more sophisticated logic
        return source;
    }

    private Map<String, Object> getMemory(String name) {
        Map<String, Object> memory = (Map<String, Object>) this.room.memory.$get(name);
        if (memory == null) {
            this.room.memory.$put(name, JSCollections.$map());
            return getMemory(name);
        }
        return memory;
    }

    public Room getRoom() {
        return room;
    }

    private void resetCPU() {
        cpu = Game.cpu.getUsed();
    }

    private void saveCPU(String name) {
        Object prevValue = cpuMemory.$get(name);
        float value = Game.cpu.getUsed() - cpu;
        if (prevValue != null) {
            value += (Float) prevValue;
        }

        cpuMemory.$put(name, value);
    }
}
