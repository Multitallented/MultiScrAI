package org.redcastlemedia.multitallented.multiscrai;

import org.stjs.javascript.annotation.GlobalScope;

/**
 * Created by nick on 26/07/15.
 *
 * Provides global configuration for all other modules. This doesn't generate a class because of the
 * GlobaScope.
 */
@GlobalScope
public class Constants {

    // Creep part costs
    public static final int MOVE_COST = 50;
    public static final int WORK_COST = 100;
    public static final int CARRY_COST = 50;
    public static final int ATTACK_COST = 80;
    public static final int RANGED_ATTACK_COST = 150;
    public static final int HEAL_COST = 250;
    public static final int TOUGH_COST = 10;

}
