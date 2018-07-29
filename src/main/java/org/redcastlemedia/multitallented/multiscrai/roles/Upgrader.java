package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepActionType;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.screeps.Creep;

/**
 * var RoomController = require('RoomController');
 * var CreepAction = require('CreepAction');
 * var CreepUtil = require('CreepUtil');
 */
public class Upgrader extends CreepRole {

    public Upgrader(Creep creep) {
        super(creep, CreepType.UPGRADER);
    }

    public void determineAction(RoomController roomController) {
        if (getCreep().carry.energy < getCreep().carryCapacity && (this.action.getAction() == null ||
                !this.action.getAction().equals(CreepActionType.UPGRADE_CONTROLLER))) {
            this.action.setAction(CreepActionType.HARVEST);
        } else {
            this.action.setAction(CreepActionType.UPGRADE_CONTROLLER);
        }
        getCreep().memory.$put(CreepAction.KEY, super.action);
    }
}
