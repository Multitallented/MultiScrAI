package org.redcastlemedia.multitallented.multiscrai.roles;

import org.junit.Before;
import org.junit.Test;
import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepActionType;
import org.redcastlemedia.multitallented.multiscrai.screeps.RoomImpl;
import org.redcastlemedia.multitallented.screeps.*;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

import static org.junit.Assert.assertEquals;

public class RoleTests {
    private Upgrader upgrader;
    private RoomController roomController;
    private RoomImpl room1;
    private Source source;

    @Before
    public void setup() {
        this.room1 = new RoomImpl("W10N10", JSCollections.$map());
        this.source = new Source();
        source.pos = new RoomPosition(10, 10, "W10N10");
        room1.sources.push(source);
        Game.rooms.$put(room1.name,room1);
        this.roomController = new RoomController(room1);
        Creep creep = createUpgrader(0);
        this.upgrader = new Upgrader(creep);
    }

    @Test
    public void upgraderHarvest() {
        this.upgrader.action.setAction(CreepActionType.UPGRADE_CONTROLLER);
        this.upgrader.determineAction(roomController);
        assertEquals(CreepActionType.HARVEST, this.upgrader.action.getAction());
    }

    @Test
    public void upgraderShouldHarvestUntilFull() {
        this.upgrader = new Upgrader(createUpgrader(2));
        this.upgrader.determineAction(roomController);
        assertEquals(CreepActionType.HARVEST, this.upgrader.action.getAction());
    }

    @Test
    public void upgraderUpgrades() {
        this.upgrader = new Upgrader(createUpgrader(300));
        this.upgrader.determineAction(roomController);
        assertEquals(CreepActionType.UPGRADE_CONTROLLER, this.upgrader.action.getAction());
    }

    @Test
    public void upgraderShouldMoveTowardsSource() {
        this.upgrader = new Upgrader(createUpgrader(0));
        this.upgrader.run(roomController);
        assertEquals(24, this.upgrader.getCreep().pos.x);
        assertEquals(24, this.upgrader.getCreep().pos.y);
    }

    @Test
    public void upgraderShouldMoveTowardsController() {
        this.upgrader = new Upgrader(createUpgrader(300));
        this.upgrader.run(roomController);
        assertEquals(26, this.upgrader.getCreep().pos.x);
        assertEquals(26, this.upgrader.getCreep().pos.y);
    }

    @Test
    public void upgraderShouldntStopUpgradingUntilEmpty() {
        this.upgrader = new Upgrader(createUpgrader(4));
        this.upgrader.action.setAction(CreepActionType.UPGRADE_CONTROLLER);
        this.upgrader.determineAction(roomController);
        assertEquals(CreepActionType.UPGRADE_CONTROLLER,this.upgrader.action.getAction());
    }

    private Creep createUpgrader(int energy) {
        Creep creep = new Creep();
        Map<String, Object> memory = JSCollections.$map("memory", (Object) new CreepAction(null));
        creep.memory = memory;
        creep.room = new RoomImpl("W10N10", JSCollections.$map());
        creep.pos = new RoomPosition(25,25, "W10N10");
        Carry carry = new Carry();
        carry.energy = energy;
        creep.carry = carry;
        creep.carryCapacity = 300;
        return creep;
    }
}
