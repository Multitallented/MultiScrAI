package com.nicktoony.scrAI;

import com.nicktoony.scrAI.Controllers.GlobalManager;
import com.nicktoony.screeps.Game;
import org.stjs.javascript.Global;

/**
 * Created by nick on 26/07/15.
 *
 *  var stjs = require("stjs");
 *  var GlobalManager = require("GlobalManager");
 */
public class main {
    public static void main(String[] args) {
        new GlobalManager();
        Global.console.log("Tick Finished, used CPU: " + Game.cpu.getUsed());
    }
}