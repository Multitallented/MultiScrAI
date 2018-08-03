package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepActionType;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.screeps.Creep;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

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
        boolean nullAction = this.action.getAction() == null;

        if (nullAction) {
            if (getCreep().carry.energy > getCreep().carryCapacity/2) {
                this.action.setAction(CreepActionType.UPGRADE_CONTROLLER);
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
                this.action.setAction(CreepActionType.UPGRADE_CONTROLLER);
            }
        }

    }
}
