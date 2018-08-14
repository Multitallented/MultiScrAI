package org.redcastlemedia.multitallented.multiscrai;

import org.redcastlemedia.multitallented.multiscrai.controllers.GlobalManager;
import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.global.console;

/**
 * Created by nick on 26/07/15.
 *
 */
public class main {
    public static void main(String[] args) {
        new GlobalManager();
//        console.log("Tick Finished, used CPU: " + Game.cpu.getUsed());
    }
}