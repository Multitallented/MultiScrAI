package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.global.PartTypes;
import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.helpers.SpawningCreep;
import org.redcastlemedia.multitallented.screeps.interfaces.DepositableStructure;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public class Spawn extends DepositableStructure {

    public SpawningCreep spawning;
    public String name;
    public Map<String, Object> memory;

    public ResponseTypes canCreateCreep(Array<PartTypes> abilities, String name) {
        return ResponseTypes.OK;
    }

    public ResponseTypes spawnCreep(Array<PartTypes> abilities, String name, Map<String, Object> options) {
        this.spawning = new SpawningCreep();
        this.spawning.name = name;
        this.spawning.memory = (Map<String, Object>) options.$get("memory");
        return ResponseTypes.OK;
    }

    @Override
    public int destroy() {
        return 0;
    }

    @Override
    public int notifyWhenAttacked(boolean enabled) {
        return 0;
    }
}
