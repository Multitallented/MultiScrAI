package org.redcastlemedia.multitallented.multiscrai.controllers;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback1;
import org.redcastlemedia.multitallented.multiscrai.orders.HarvestOrder;
import org.redcastlemedia.multitallented.multiscrai.orders.RespawnOrder;
import org.redcastlemedia.multitallented.multiscrai.roles.CreepRole;
import org.redcastlemedia.multitallented.multiscrai.roles.StructureRole;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepUtil;
import org.redcastlemedia.multitallented.screeps.*;
import org.redcastlemedia.multitallented.screeps.global.FindTypes;
import org.redcastlemedia.multitallented.screeps.global.StructureTypes;
import org.redcastlemedia.multitallented.screeps.global.console;
import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public class RoomController {

    private final RoomController roomController;
    // room globals

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
        Object check = room.memory.$get(key);
        if (check == null) {
            check = value;
        }
        return check;
    }

    private void putMemory(String key, Object value) {
        room.memory.$put(key, value);
    }

    public void step() {
        Array<Creep> creeps = (Array<Creep>) room.find(FindTypes.FIND_CREEPS, JSCollections.$map());
        final Map<String, Integer> creepTypes = JSCollections.$map();
        final CreepUtil creepUtil = new CreepUtil();
        final RoomController roomController = this.roomController;
        Lodash.forIn(creeps, new LodashCallback1<Creep>() {

            @Override
            public boolean invoke(Creep creep) {
                CreepRole creepRole = creepUtil.getCreepRole(creep, roomController);

                if (creepRole != null && creepRole.getType() != null) {
                    String type = creepRole.getType().toString();
                    if (creepTypes.$get(type) != null) {
                        creepTypes.$put(type, creepTypes.$get(type) + 1);
                    } else {
                        creepTypes.$put(type, 1);
                    }
                    creepRole.run(roomController);
                }
                return true;
            }
        }, roomController);

//
        Array<Structure> structures = (Array<Structure>) room.find(FindTypes.FIND_STRUCTURES, JSCollections.$map());
        Array<ConstructionSite> sites = (Array<ConstructionSite>) room.find(FindTypes.FIND_CONSTRUCTION_SITES, JSCollections.$map());
        //TODO roomBuilder?

        Map<String, Integer> structureTypes = JSCollections.$map();
        Spawn spawn = null;
        for (int i = 0; i < structures.$length(); i++) {
            Structure structure = structures.$get(i);
            StructureRole structureRole = new StructureRole(structure);
            if (structureRole.getType() != null) {
                String type = structureRole.getType().toString();
                if (structureTypes.$get(type) != null) {
                    structureTypes.$put(type, structureTypes.$get(type) + 1);
                } else {
                    structureTypes.$put(type, 1);
                }
            }

            if (structure.structureType == StructureTypes.STRUCTURE_SPAWN) {
                spawn = (Spawn) structure;
            }
        }

        if (spawn != null) {
            RespawnOrder.run(creepTypes, spawn, structureTypes, sites.$length() > 0, roomController);
        }

        //TODO add room logic
    }

    public Source getAvailableHarvest(RoomPosition roomPosition, boolean reserve) {
        return HarvestOrder.getAvailableHarvest(roomPosition, reserve);
    }

    private Map<String, Object> getMemory(String name) {
        Map<String, Object> memory = (Map<String, Object>) room.memory.$get(name);
        if (memory == null) {
            room.memory.$put(name, JSCollections.$map());
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
