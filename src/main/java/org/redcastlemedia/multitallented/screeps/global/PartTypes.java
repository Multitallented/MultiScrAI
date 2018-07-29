package org.redcastlemedia.multitallented.screeps.global;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/2015.
 */
@GlobalScope
@STJSBridge
public enum PartTypes {
    MOVE,
    WORK,
    CARRY,
    ATTACK,
    RANGED_ATTACK,
    HEAL,
    TOUGH
}
