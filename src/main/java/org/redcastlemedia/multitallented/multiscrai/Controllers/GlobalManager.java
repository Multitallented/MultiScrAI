package org.redcastlemedia.multitallented.multiscrai.Controllers;

import org.redcastlemedia.multitallented.helpers.Lodash;
import org.redcastlemedia.multitallented.helpers.LodashCallback2;
import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.Room;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

/**
 * Created by nick on 26/07/15.
 *  var stjs = require("stjs");
 *  var Constants = require("Constants");
 *  var RoomController = require("RoomController");
 *  var Lodash = require('lodash');
 */
public class GlobalManager {
    private Array<RoomController> roomControllers;

    public GlobalManager() {
        roomControllers = new Array<RoomController>();

        Lodash.forIn(Game.rooms, new LodashCallback2<Room, String>() {
            @Override
            public boolean invoke(Room room, String name) {
                // Create a room controller
                roomControllers.push(new RoomController(room));
                return true;
            }
        }, this);

        roomControllers.forEach(new Callback1<RoomController>() {
            @Override
            public void $invoke(RoomController roomController) {
                roomController.step();
            }
        });
    }
}
