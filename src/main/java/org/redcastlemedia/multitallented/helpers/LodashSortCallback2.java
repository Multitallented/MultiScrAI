package org.redcastlemedia.multitallented.helpers;

import org.stjs.javascript.annotation.JavascriptFunction;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
@JavascriptFunction
public interface LodashSortCallback2<Var1, Var2> extends LodashSortCallback {
    int invoke(Var1 variable1, Var2 variable2);
}
