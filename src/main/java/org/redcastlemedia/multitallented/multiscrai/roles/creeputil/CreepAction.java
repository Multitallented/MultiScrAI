package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import org.stjs.javascript.Map;

public class CreepAction {
    public static final String KEY = "action";
    public static final String TARGET_ID = "targetId";

    public CreepAction(Map<String, Object> currentOrder) {
        if (currentOrder != null) {
            this.targetId = (String) currentOrder.$get(TARGET_ID);
            this.action = CreepActionType.valueOf((String) currentOrder.$get(KEY));
        }
    }

    private String targetId;
    private CreepActionType action;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public CreepActionType getAction() {
        return action;
    }

    public void setAction(CreepActionType action) {
        this.action = action;
    }
}
