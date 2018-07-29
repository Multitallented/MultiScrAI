package org.redcastlemedia.multitallented.multiscrai.roles.creeputil;

import java.lang.reflect.Field;

public class CreepAction {

    public CreepAction(Object currentOrder) {
        if (currentOrder != null) {
            try {
                Field field = currentOrder.getClass().getField("targetId");
                this.targetId = (String) field.get(currentOrder);

                Field field1 = currentOrder.getClass().getField("action");
                this.action = ActionType.valueOf((String) field1.get(currentOrder));
            } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }
        }
    }

    private String targetId;
    private ActionType action;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }


    public enum ActionType {
        MOVE,
        HARVEST,
        UPGRADE_CONTROLLER
    }
}
