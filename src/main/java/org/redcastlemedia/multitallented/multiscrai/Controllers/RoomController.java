package org.redcastlemedia.multitallented.multiscrai.Controllers;

import org.redcastlemedia.multitallented.screeps.Game;
import org.redcastlemedia.multitallented.screeps.Room;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;

/**
 * Created by nick on 26/07/15.
 */
public class RoomController {

    // room globals
    public boolean hasPathFound = false;

    private Room room;
    private Map<String, Object> cpuMemory;
    private float cpu = 0;

    public RoomController(Room room) {
        this.room = room;

        // Check if memory is defined
        if (this.room.memory.$get("created") == null) {
            this.room.memory.$put("created", true);
        }
        this.cpuMemory = getMemory("cpuMemory");
    }

    private Object getMemoryOrDefault(String key, Object value) {
        Object check = this.room.memory.$get(key);
        if (check == null) {
            check = value;
        }
        return check;
    }

    private void putMemory(String key, Object value) {
        this.room.memory.$put(key, value);
    }

    public void step() {
        //TODO add room logic
    }

    private Map<String, Object> getMemory(String name) {
        Map<String, Object> memory = (Map<String, Object>) this.room.memory.$get(name);
        if (memory == null) {
            this.room.memory.$put(name, JSCollections.$map());
            return getMemory(name);
        }
        return memory;
    }

    public Room getRoom() {
        return room;
    }

    private void resetCPU() {
        cpu = Game.cpu.getUsed();
    }

    private void saveCPU(String name) {
        Object prevValue = cpuMemory.$get(name);
        float value = Game.cpu.getUsed() - cpu;
        if (prevValue != null) {
            value += (Float) prevValue;
        }

        cpuMemory.$put(name, value);
    }
}
