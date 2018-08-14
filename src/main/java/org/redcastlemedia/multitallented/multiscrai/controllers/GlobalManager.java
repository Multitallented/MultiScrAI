package org.redcastlemedia.multitallented.multiscrai.controllers;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback;
import org.redcastlemedia.multitallented.helpers.LodashCallback1;
import org.redcastlemedia.multitallented.helpers.LodashCallback2;
import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.Room;
import org.redcastlemedia.multitallented.screeps.global.Memory;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

public class GlobalManager {

    public GlobalManager() {
        GlobalManager globalManager = this;

        deleteOrphanedMemory();

        final Array<RoomController> roomControllers = new Array<>();

        Lodash.forIn(Game.rooms, new LodashCallback2<Room, String>() {
            @Override
            public boolean invoke(Room room, String roomName) {
                roomControllers.push(new RoomController(room));
                return true;
            }
        }, globalManager);

        roomControllers.forEach(new Callback1<RoomController>() {
            @Override
            public void $invoke(RoomController roomController) {
                roomController.step();
            }
        });
    }

    private void deleteOrphanedMemory() {
        final Array<String> removeMe = new Array<>();
        Lodash.forIn(Memory.creeps, new LodashCallback2<Object, String>() {

            @Override
            public boolean invoke(Object variable1, String key) {
                if (Game.creeps.$get(key) == null) {
                    removeMe.push(key);
                }
                return true;
            }
        }, this);
        Lodash.forIn(removeMe, new LodashCallback1<String>() {
            @Override
            public boolean invoke(String key) {
                Memory.creeps.$delete(key);
                return true;
            }
        }, this);
    }
}
