package org.redcastlemedia.multitallented.screeps.global;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 10/08/2015.
 */
@GlobalScope
@STJSBridge
public enum ResponseTypes {
    OK,
    ERR_NOT_OWNER,
    ERR_NO_PATH,
    ERR_NAME_EXISTS,
    ERR_BUSY,
    ERR_NOT_FOUND,
    ERR_NOT_ENOUGH_ENERGY,
    ERR_NOT_ENOUGH_RESOURCES,
    ERR_INVALID_TARGET,
    ERR_FULL,
    ERR_NOT_IN_RANGE,
    ERR_INVALID_ARGS,
    ERR_TIRED,
    ERR_NO_BODYPART,
    ERR_NOT_ENOUGH_EXTENSIONS,
    ERR_RCL_NOT_ENOUGH,
    ERR_GCL_NOT_ENOUGH
}
