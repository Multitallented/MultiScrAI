package org.redcastlemedia.multitallented.helpers;

import org.stjs.javascript.annotation.JavascriptFunction;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
@JavascriptFunction
public interface LodashCallback2<T1, T2> extends LodashCallback {
    boolean invoke(T1 variable1, T2 variable2);
}
