package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

/**
 * Created by nick on 26/07/15.
 */
public class Game {
    public static Array<Room> rooms;
    public static int time;
    public static Array<Creep> creeps;
    public static Map<String, Spawn> spawns;

    static {
        rooms = new Array<>();
        creeps = new Array<>();
        spawns = JSCollections.$map();
        time = (int) (Math.floor(Math.random() * 100000) + 100000);
    }

    public static Object getObjectById(Object target) {
        return null;
    }

    public static class cpu {
        public static int limit = 100;
        public static int tickLimit = 100;
        public static int bucket = 100;
        public static Object shardLimits;

        public static int getUsed() {
            return 0;
        }

        public static Object getHeapStatistics() {
            return null;
        }

        public static int setShardLimits(Object limits) {
            return 0;
        }
    }
}
