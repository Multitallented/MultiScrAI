package org.redcastlemedia.multitallented.screeps.global;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/2015.
 */
@GlobalScope
@STJSBridge
public enum FindTypes {
    FIND_CREEPS,
    FIND_MY_CREEPS,
    FIND_HOSTILE_CREEPS,
    FIND_MY_SPAWNS,
    FIND_HOSTILE_SPAWNS,
    FIND_SOURCES,
    FIND_SOURCES_ACTIVE,
    FIND_DROPPED_ENERGY,
    FIND_STRUCTURES,
    FIND_MY_STRUCTURES,
    FIND_HOSTILE_STRUCTURES,
    FIND_FLAGS,
    FIND_CONSTRUCTION_SITES,
    FIND_EXIT_TOP,
    FIND_EXIT_RIGHT,
    FIND_EXIT_BOTTOM,
    FIND_EXIT_LEFT,
    FIND_EXIT
}
