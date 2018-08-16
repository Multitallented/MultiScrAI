package org.redcastlemedia.multitallented.multiscrai.roles;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepAction;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepActionType;
import org.redcastlemedia.multitallented.multiscrai.screeps.RoomImpl;
import org.redcastlemedia.multitallented.screeps.*;
import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

import static org.junit.Assert.assertEquals;

public class HarvesterTests {
    private Harvester harvester;
    private RoomController roomController;
    private Spawn spawn;
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
        this.spawn = new Spawn();
        this.spawn.pos = new RoomPosition(40, 40, "W10N10");
        Creep creep = UpgraderTests.createCreep(0);
        this.harvester = new Harvester(creep);
    }

    @Test
    public void upgraderHarvest() {
        this.harvester.action.setAction(CreepActionType.DEPOSIT_ENERGY);
        this.harvester.determineAction(roomController);
        assertEquals(CreepActionType.HARVEST, this.harvester.action.getAction());
    }

    @Test
    public void harvesterShouldHarvestUntilFull() {
        this.harvester = new Harvester(UpgraderTests.createCreep(2));
        this.harvester.determineAction(roomController);
        assertEquals(CreepActionType.HARVEST, this.harvester.action.getAction());
    }

    @Test
    public void harvesterTransfers() {
        this.harvester = new Harvester(UpgraderTests.createCreep(300));
        this.harvester.determineAction(roomController);
        assertEquals(CreepActionType.DEPOSIT_ENERGY, this.harvester.action.getAction());
    }

    @Test
    public void harvesterShouldMoveTowardsSource() {
        this.harvester = new Harvester(UpgraderTests.createCreep(0));
        this.harvester.run(roomController);
        assertEquals(24, this.harvester.getCreep().pos.x);
        assertEquals(24, this.harvester.getCreep().pos.y);
    }

    @Test
    @Ignore
    public void harvesterShouldMoveTowardsSpawn() {
        this.harvester = new Harvester(UpgraderTests.createCreep(300));
        this.harvester.run(roomController);
        assertEquals(26, this.harvester.getCreep().pos.x);
        assertEquals(26, this.harvester.getCreep().pos.y);
    }

    @Test
    public void harvesterShouldntStopUpgradingUntilEmpty() {
        this.harvester = new Harvester(UpgraderTests.createCreep(4));
        this.harvester.action.setAction(CreepActionType.DEPOSIT_ENERGY);
        this.harvester.determineAction(roomController);
        assertEquals(CreepActionType.DEPOSIT_ENERGY,this.harvester.action.getAction());
    }
}
