package org.redcastlemedia.multitallented.multiscrai.roles;

import org.redcastlemedia.multitallented.screeps.structures.Structure;

public class StructureRole {
    private final Structure structure;
    private final String type;

    public StructureRole(Structure structure) {
        this.structure = structure;
        this.type = structure.structureType;
    }

    public Structure getStructure() {
        return structure;
    }

    public String getType() {
        return type;
    }
}
