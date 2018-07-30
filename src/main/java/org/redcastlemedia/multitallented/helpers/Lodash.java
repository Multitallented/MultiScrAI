package org.redcastlemedia.multitallented.helpers;

import org.stjs.javascript.Array;
import org.stjs.javascript.annotation.STJSBridge;

import java.lang.reflect.Field;

/**
 * Created by nick on 26/07/15.
 */
@STJSBridge
public class Lodash {
    public static void forIn(Object object, LodashCallback iteratee, Object bind) {
        for(Field field : object.getClass().getFields()) {
            if (iteratee instanceof LodashCallback1) {
                try {
                    ((LodashCallback1) iteratee).invoke(field.get(object));
                } catch (IllegalAccessException exception) {

                }
            } else if (iteratee instanceof LodashCallback2) {
                try {
                    ((LodashCallback2) iteratee).invoke(field.get(object), field.getName());
                } catch (IllegalAccessException exception) {

                }
            }
        }
    }

    public static Array<?> sortBy(Object collection, LodashSortCallback iteratee, Object bind) {
        //TODO fix this
        return (Array<?>) collection;
    }
}
