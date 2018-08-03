package org.redcastlemedia.multitallented.screeps.helpers;

import org.redcastlemedia.multitallented.screeps.Creep;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/15.
 */
@STJSBridge
public class SpawningCreep extends Creep {
    public String name;
    public int needTime;
    public int remainingTime;
}
