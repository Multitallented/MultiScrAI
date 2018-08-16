package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepActionType;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.screeps.Creep;

public class Harvester extends CreepRole {

    public Harvester(Creep creep) {
        super(creep, CreepType.HARVESTER);
    }

    public void determineAction(RoomController roomController) {
        boolean nullAction = this.action.getAction() == null;

        if (nullAction) {
            if (getCreep().carry.energy == getCreep().carryCapacity) {
                this.action.setAction(CreepActionType.DEPOSIT_ENERGY);
            }
            else {
                this.action.setAction(CreepActionType.HARVEST);
            }
        }
        else {
            if (getCreep().carry.energy == 0) {
                this.action.setAction(CreepActionType.HARVEST);
            }
            else if (getCreep().carry.energy == getCreep().carryCapacity){
                this.action.setAction(CreepActionType.DEPOSIT_ENERGY);
            }
        }

    }
}
