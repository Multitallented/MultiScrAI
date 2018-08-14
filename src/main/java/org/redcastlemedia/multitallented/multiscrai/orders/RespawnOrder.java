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

public class RespawnOrder {
    public static void run(Map<String, Integer> creepTypes,
                           Spawn spawn,
                           Map<String, Integer> structureTypes,
                           boolean hasConstruction,
                           RoomController roomController) {

        Integer upgraderCount = creepTypes.$get(CreepType.UPGRADER.toString());
        if ((upgraderCount == null || upgraderCount < 1) && roomController.getRoom().energyAvailable > 199) {
            Array<PartTypes> body = new Array<>();
            body.push(PartTypes.WORK);
            body.push(PartTypes.CARRY);
            body.push(PartTypes.MOVE);

            Map<String, String> memory = JSCollections.$map("role", CreepType.UPGRADER.toString());

            Map<String, Object> options = JSCollections.$map("memory", (Object) memory);

            spawn.spawnCreep(body,CreepType.UPGRADER.toString() + Game.time, options);
        }
    }
}
