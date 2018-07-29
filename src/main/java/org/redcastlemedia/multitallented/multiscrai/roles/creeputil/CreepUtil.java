package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import org.redcastlemedia.multitallented.multiscrai.Controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.CreepRole;
import org.redcastlemedia.multitallented.multiscrai.roles.Upgrader;
import org.redcastlemedia.multitallented.screeps.Creep;

public class CreepUtil {
    public static final String UPGRADER = "upgrader";

    public static CreepRole getCreepRole(Creep creep, RoomController roomController) {
        switch (getRoleString(creep)) {
            case CreepUtil.UPGRADER:
                return new Upgrader(creep);
            default:
                return null;
        }
    }

    public static void runByRole(Creep creep, RoomController roomController) {
        if (getRoleString(creep).equals(CreepUtil.UPGRADER)) {
            new Upgrader(creep).run(roomController);
        }
    }

    private static String getRoleString(Creep creep) {
        return (String) creep.memory.$get("role");
    }
}
