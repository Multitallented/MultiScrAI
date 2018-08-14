package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.CreepRole;
import org.redcastlemedia.multitallented.multiscrai.roles.Upgrader;
import org.redcastlemedia.multitallented.screeps.Creep;
import org.redcastlemedia.multitallented.screeps.global.console;

public class CreepUtil {

    public CreepRole getCreepRole(Creep creep, RoomController roomController) {
        switch (getRoleString(creep)) {
            case UPGRADER:
                return new Upgrader(creep);
            default:
                return null;
        }
    }

    public void runByRole(Creep creep, RoomController roomController) {
        if (getRoleString(creep).equals(CreepType.UPGRADER)) {
            new Upgrader(creep).run(roomController);
        }
    }

    private CreepType getRoleString(Creep creep) {
        if (creep == null || creep.memory == null) {
            return null;
        }
        String role = (String) creep.memory.$get("role");
        if (role == null) {
            return null;
        }
        return CreepType.valueOf(role.toUpperCase());
    }
}
