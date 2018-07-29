package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.Controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.screeps.Creep;

public class Upgrader extends CreepRole{

    public Upgrader(Creep creep) {
        super(creep);
    }

    public void determineAction(RoomController roomController) {
        if (getCreep().carry.energy < getCreep().carryCapacity) {
            this.action.setAction(CreepAction.ActionType.HARVEST);
        } else {
            this.action.setAction(CreepAction.ActionType.UPGRADE_CONTROLLER);
        }
    }
}
