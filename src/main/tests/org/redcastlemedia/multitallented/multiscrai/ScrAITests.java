package org.redcastlemedia.multitallented.multiscrai;

import org.redcastlemedia.multitallented.multiscrai.Controllers.GlobalManager;
import org.redcastlemedia.multitallented.multiscrai.screeps.RoomImpl;
import org.junit.Before;
import org.junit.Test;
import org.redcastlemedia.multitallented.screeps.Game;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;


public class ScrAITests {

    @Before
    public void setup() {
        Game.rooms = new Array<>();
        Game.rooms.push(new RoomImpl("Room1", JSCollections.$map()));
    }

    @Test
    public void globalManagerShouldntCrash() {
        new GlobalManager();
    }

}
