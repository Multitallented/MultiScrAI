package org.redcastlemedia.multitallented.multiscrai.orders;

import org.junit.Before;
import org.junit.Test;
import org.redcastlemedia.multitallented.multiscrai.controllers.RoomController;
import org.redcastlemedia.multitallented.multiscrai.roles.creeputil.CreepType;
import org.redcastlemedia.multitallented.multiscrai.screeps.RoomImpl;
import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.stjs.javascript.JSCollections;

import static org.junit.Assert.*;

public class RespawnOrderTests {
    private Spawn spawn;
    private RoomImpl room;
    private RoomController roomController;

    @Before
    public void setup() {
        this.spawn = new Spawn();
        this.room = new RoomImpl("Room1", JSCollections.$map());
        this.room.energyAvailable = 300;
        this.roomController = new RoomController(this.room);
    }

    @Test
    public void spawnShouldSpawnUpgrader() {
        RespawnOrder.run(JSCollections.<String, Integer>$map(), this.spawn,
                JSCollections.<String, Integer>$map(),false, this.roomController);
        assertEquals(CreepType.UPGRADER.toString(), this.spawn.spawning.memory.$get("role"));
    }

    @Test
    public void spawnShouldntSpawnUpgrader() {
        RespawnOrder.run(JSCollections.<String, Integer>$map(CreepType.UPGRADER.toString(), 1), this.spawn,
                JSCollections.<String, Integer>$map(),false, this.roomController);
        assertTrue(this.spawn.spawning == null);
    }
}
