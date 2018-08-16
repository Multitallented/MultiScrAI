package org.redcastlemedia.multitallented.screeps.structures;

import org.redcastlemedia.multitallented.screeps.interfaces.DepositableStructure;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/15.
 */
@STJSBridge
public class Extension extends DepositableStructure {

    @Override
    public int destroy() {
        return 0;
    }

    @Override
    public int notifyWhenAttacked(boolean enabled) {
        return 0;
    }

}
