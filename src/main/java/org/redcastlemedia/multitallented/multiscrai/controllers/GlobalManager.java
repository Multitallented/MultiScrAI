package org.redcastlemedia.multitallented.multiscrai.controllers;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback2;
import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.Room;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;

/**
 *  var stjs = require("stjs");
 *  var Constants = require("Constants");
 *  var RoomController = require("RoomController");
 *  var Lodash = require('lodash');
 */
public class GlobalManager {

    public GlobalManager() {
        GlobalManager globalManager = this;
        final Array<RoomController> roomControllers = new Array<>();

        Lodash.forIn(Game.rooms, new LodashCallback2<Room, String>() {
            @Override
            public boolean invoke(Room room, String name) {
                // Create a room controller
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
}
