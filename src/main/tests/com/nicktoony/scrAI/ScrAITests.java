package com.nicktoony.scrAI;

import com.nicktoony.scrAI.Controllers.GlobalManager;
import com.nicktoony.scrAI.screeps.RoomImpl;
import com.nicktoony.screeps.Game;
import com.nicktoony.screeps.Room;
import org.junit.Before;
import org.junit.Test;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;

import static org.mockito.Mockito.mock;

public class ScrAITests {

    @Before
    public void setup() {
        Game.rooms = new Array<Room>();
        Map<String, Object> memory = mock(Map.class);
        Game.rooms.push(new RoomImpl("Room1", memory));
    }

    @Test
    public void globalManagerShouldntCrash() {
        new GlobalManager();
    }

}
