package org.redcastlemedia.multitallented.multiscrai.orders;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.StructureRole;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepUtil;
import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.global.PartTypes;
import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

/**
 * var RoomController = require('RoomController');
 */
public class RespawnOrder {
    public static void run(Map<String, Integer> creepTypes,
                           Spawn spawn,
                           Map<String, Integer> structureTypes,
                           boolean hasConstruction,
                           RoomController roomController) {
        if (creepTypes.$get(CreepType.UPGRADER.toString()) < 1 && roomController.getRoom().energyAvailable > 199) {
            Array<PartTypes> body = new Array<>();
            body.push(PartTypes.WORK);
            body.push(PartTypes.CARRY);
            body.push(PartTypes.MOVE);
            spawn.spawnCreep(body,CreepType.UPGRADER.toString() + Game.time,JSCollections.$map("role", (Object) CreepType.UPGRADER.toString()));
        }
    }
}
