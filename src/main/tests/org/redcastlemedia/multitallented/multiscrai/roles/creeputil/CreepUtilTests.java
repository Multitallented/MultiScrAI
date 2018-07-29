package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreepUtilTests {

    @Test
    public void creepActionShouldParseMemoryObject() {
        CreepAction creepAction = new CreepAction(new CreepMemoryAction());
        assertEquals("3n48cenwo", creepAction.getTargetId());
        assertEquals(CreepAction.ActionType.MOVE, creepAction.getAction());
    }

    public class CreepMemoryAction {
        public String targetId = "3n48cenwo";
        public String action = "MOVE";
    }

    @Test
    public void newCreepActionShouldNotThrowException() {
        new CreepAction(null);
    }
}
