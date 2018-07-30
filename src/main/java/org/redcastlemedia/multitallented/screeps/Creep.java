package org.redcastlemedia.multitallented.screeps;

import org.redcastlemedia.multitallented.screeps.global.ResponseTypes;
import org.redcastlemedia.multitallented.screeps.global.ScreepsObject;
import org.redcastlemedia.multitallented.screeps.interfaces.StorableStructure;
import org.redcastlemedia.multitallented.screeps.structures.Controller;
import org.redcastlemedia.multitallented.screeps.structures.Structure;
import org.redcastlemedia.multitallented.screeps.interfaces.DepositableStructure;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.annotation.Adapter;
import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge
public class Creep extends ScreepsObject {
    public String name;
    public RoomPosition pos;
    public Map<String, Object> memory;
    public Array<String> body;
    public Carry carry;
    public int carryCapacity;
    public int fatigue;

    public Creep() {
        memory = JSCollections.$map();
    }

    public ResponseTypes harvest(Source source) {
        if (RoomPosition.distance(source.pos, pos) > 1) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        return ResponseTypes.OK;
    }

    public ResponseTypes moveTo(ScreepsObject target, Map<String, ?> opts) {
        if (fatigue > 0) {
            return ResponseTypes.ERR_TIRED;
        }
        pos.x = pos.x > target.pos.x && pos.x > 0 ? pos.x - 1 :
                pos.x < target.pos.x && pos.x < 49 ? pos.x + 1 : pos.x;
        pos.y = pos.y > target.pos.y && pos.y > 0 ? pos.y - 1 :
                pos.y < target.pos.y && pos.y < 49 ? pos.y + 1: pos.y;
        return ResponseTypes.OK;
    }

    public ResponseTypes transfer(ScreepsObject target, int type) {
        return transfer(target, type, Math.min(carry.energy, carryCapacity));
    }

    public ResponseTypes transfer(ScreepsObject target, int type, int amount) {
        if (RoomPosition.distance(target.pos, pos) > 1) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        if (target instanceof DepositableStructure) {
            DepositableStructure depo = (DepositableStructure) target;
            int diff = depo.energyCapacity - depo.energy;
            if (diff > amount) {
                depo.energy = depo.energy + amount;
                carry.energy -= amount;
            } else {
                carry.energy -= diff;
                depo.energy = depo.energyCapacity;
            }
        } else if (target instanceof StorableStructure) {
            StorableStructure depo = (StorableStructure) target;
            int diff = depo.storageCapacity - depo.store.energy;
            if (diff > amount) {
                depo.store.energy = depo.store.energy + amount;
                carry.energy -= amount;
            } else {
                carry.energy -= diff;
                depo.store.energy = depo.storageCapacity;
            }
        } else {
            return ResponseTypes.ERR_INVALID_TARGET;
        }
        return ResponseTypes.OK;
    }

    public ResponseTypes pickup(Energy energy) {
        if (RoomPosition.distance(energy.pos, pos) > 1) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        if (carryCapacity > energy.energy + carry.energy) {
            carry.energy = carry.energy + energy.energy;
            energy.energy = 0;
        } else {
            energy.energy -= carryCapacity - carry.energy;
            carry.energy = carryCapacity;
        }
        return ResponseTypes.OK;
    }

    public ResponseTypes upgradeController(Controller controller) {
        if (RoomPosition.distance(controller.pos, pos) > 1) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        return ResponseTypes.OK;
    }

    public ResponseTypes build(ConstructionSite buildable) {
        if (RoomPosition.distance(buildable.pos, pos) > 3) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        return ResponseTypes.OK;
    }

    public ResponseTypes repair(Structure buildable) {
        if (RoomPosition.distance(buildable.pos, pos) > 1) {
            return ResponseTypes.ERR_NOT_IN_RANGE;
        }
        return ResponseTypes.OK;
    }
}
