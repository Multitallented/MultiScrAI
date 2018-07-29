package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.Controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.screeps.Creep;
import org.redcastlemedia.multitallented.screeps.Room;
import org.redcastlemedia.multitallented.screeps.Source;
import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.structures.Controller;
import org.stjs.javascript.JSCollections;


public abstract class CreepRole {
    private final Room room;
    private final Creep creep;
    protected CreepAction action;

    public CreepRole(Creep creep) {
        this.creep = creep;
        this.room = creep.room;
        this.action = new CreepAction(creep.memory.$get("currentOrder"));
    }

    public Room getRoom() {
        return room;
    }

    public Creep getCreep() {
        return creep;
    }

    public void run(RoomController roomController) {
        if (creep.fatigue > 0) {
            return;
        }
        determineAction(roomController);
        doAction(roomController);
    }

    public void doAction(RoomController roomController) {
        switch (action.getAction()) {
            case UPGRADE_CONTROLLER:
                Controller controller = roomController.getRoom().controller;
                if (creep.upgradeController(controller) == ResponseTypes.ERR_NOT_IN_RANGE.getCode()) {
                    creep.moveTo(controller, JSCollections.$map());
                }
                break;
            case HARVEST:
                Source source = roomController.getAvailableHarvest(creep.pos, true);
                if (source == null) {
                    break;
                }
                if (creep.harvest(source) == ResponseTypes.ERR_NOT_IN_RANGE.getCode()) {
                    creep.moveTo(source, JSCollections.$map());
                }
                break;
        }
    }

    public abstract void determineAction(RoomController roomController);
}
