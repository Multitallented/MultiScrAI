package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.screeps.Creep;
import org.redcastlemedia.multitallented.screeps.Room;
import org.redcastlemedia.multitallented.screeps.Source;
import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.structures.Controller;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

public abstract class CreepRole {
    private final Room room;
    private final Creep creep;
    private final CreepType type;
    protected CreepAction action;

    public CreepRole(Creep creep, CreepType type) {
        this.creep = creep;
        this.room = creep.room;
        this.action = new CreepAction((Map<String, Object>) creep.memory.$get(CreepAction.KEY));
        this.type = type;
    }

    public Room getRoom() {
        return room;
    }

    public Creep getCreep() {
        return creep;
    }

    public CreepType getType() {
        return type;
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
                if (creep.upgradeController(controller) == ResponseTypes.ERR_NOT_IN_RANGE) {
                    creep.moveTo(controller, JSCollections.$map("visualizePathStyle", JSCollections.$map("stroke", "#ffffff")));
                }
                action.setTargetId(controller.id);
                break;
            case HARVEST:
                Source source = roomController.getAvailableHarvest(creep.pos, true);
                if (source == null) {
                    break;
                }
                if (creep.harvest(source) == ResponseTypes.ERR_NOT_IN_RANGE) {
                    creep.moveTo(source, JSCollections.$map("visualizePathStyle", JSCollections.$map("stroke", "#ffffff")));
                }
                action.setTargetId(source.id);
                break;
        }

        Map<String, String> actionMap = JSCollections.$map("action", action.getAction().toString(),
                "targetId", action.getTargetId());
        getCreep().memory.$put(CreepAction.KEY, actionMap);
    }

    public abstract void determineAction(RoomController roomController);
}
