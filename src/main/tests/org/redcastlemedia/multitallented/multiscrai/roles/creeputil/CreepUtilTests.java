package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import org.junit.Before;
import org.junit.Test;
import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.CreepRole;
import org.redcastlemedia.multitallented.multiscrai.roles.Upgrader;
import org.redcastlemedia.multitallented.multiscrai.screeps.RoomImpl;
import org.redcastlemedia.multitallented.screeps.Creep;
import org.stjs.javascript.JSCollections;

import static org.junit.Assert.*;

public class CreepUtilTests {

    private RoomController roomController;

    @Before
    public void setup() {
        this.roomController = new RoomController(new RoomImpl("Room1", JSCollections.$map()));
    }

    @Test
    public void creepActionShouldParseMemoryObject() {
        CreepAction creepAction = new CreepAction(JSCollections.$map("targetId", (Object) "3n48cenwo", "action", "MOVE"));
        assertEquals("3n48cenwo", creepAction.getTargetId());
        assertEquals(CreepActionType.MOVE, creepAction.getAction());
    }

    @Test
    public void newCreepActionShouldNotThrowException() {
        CreepAction creepAction = new CreepAction(null);
        assertNotNull(creepAction);
        assertNull(creepAction.getAction());
    }

    @Test
    public void creepShouldHaveUpgraderRole() {
        Creep creep = new Creep();
        creep.memory.$put("role", "UPGRADER");
        CreepUtil creepUtil = new CreepUtil();
        CreepRole creepRole = creepUtil.getCreepRole(creep, roomController);
        assertTrue(creepRole instanceof Upgrader);
    }
}
