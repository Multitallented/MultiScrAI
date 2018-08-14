package org.redcastlemedia.multitallented.multiscrai.orders;

import org.redcastlemedia.multitallented.screeps.RoomPosition;
import org.redcastlemedia.multitallented.screeps.Source;
import org.redcastlemedia.multitallented.screeps.global.FindTypes;
import org.stjs.javascript.JSCollections;

public class HarvestOrder {
    public static Source getAvailableHarvest(RoomPosition roomPosition, boolean reserve) {
        Source source = (Source) roomPosition.findClosestByRange(FindTypes.FIND_SOURCES, JSCollections.$map());
        return source;
    }
}
