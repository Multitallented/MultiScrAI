package org.redcastlemedia.multitallented.multiscrai.orders;

import org.redcastlemedia.multitallented.helpers.LodashCallback1;
import org.redcastlemedia.multitallented.screeps.RoomPosition;
import org.redcastlemedia.multitallented.screeps.global.FindTypes;
import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.redcastlemedia.multitallented.screeps.structures.Extension;
import org.redcastlemedia.multitallented.screeps.structures.Spawn;
import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.stjs.javascript.JSCollections;

public class DepositEnergyOrder {

    public static String getAvailableDepositEnergy(RoomPosition pos) {
        ScreepsObject screepsObject = pos.findClosestByRange(FindTypes.FIND_STRUCTURES,
                JSCollections.$map("filter", (Object) (new LodashCallback1<Structure>() {
                    @Override
                    public boolean invoke(Structure structure) {

                        return isValidDespositCandidate(structure);
                    }
                })));
        return screepsObject == null ? null : screepsObject.id;
    }

    private static boolean isValidDespositCandidate(Structure structure) {
        if (structure.structureType.equals("spawn")) {
            Spawn spawn = (Spawn) structure;
            return spawn.energy < spawn.energyCapacity;
        } else if (structure.structureType.equals("extension")) {
            Extension extension = (Extension) structure;
            return extension.energy < extension.energyCapacity;
        }

        return false;
    }
}
