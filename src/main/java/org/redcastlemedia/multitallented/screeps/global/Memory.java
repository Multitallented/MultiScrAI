package org.redcastlemedia.multitallented.screeps.global;

import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public class Memory {
    public static Map<String, Object> sources;
    public static Map<String, Object> creeps = JSCollections.$map();
    public static Map<String, Spawn> spawns;
}
