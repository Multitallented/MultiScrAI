package org.redcastlemedia.multitallented.helpers;

import org.stjs.javascript.annotation.JavascriptFunction;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
@JavascriptFunction
public interface LodashCallback1<T> extends LodashCallback {
    boolean invoke(T variable);
}
