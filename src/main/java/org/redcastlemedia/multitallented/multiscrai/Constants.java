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
    public static final String USERNAME = "Multitallented";

    // Creep part costs
    public static final int MOVE_COST = 50;
    public static final int WORK_COST = 100;
    public static final int CARRY_COST = 50;
    public static final int ATTACK_COST = 80;
    public static final int RANGED_ATTACK_COST = 150;
    public static final int HEAL_COST = 250;
    public static final int TOUGH_COST = 10;

    public static final String RESOURCE_ENERGY = "energy";
    public static final String RESOURCE_POWER = "power";

    public static final String RESOURCE_HYDROGEN = "H";
    public static final String RESOURCE_OXYGEN = "O";
    public static final String RESOURCE_UTRIUM = "U";
    public static final String RESOURCE_LEMERGIUM = "L";
    public static final String RESOURCE_KEANIUM = "K";
    public static final String RESOURCE_ZYNTHIUM = "Z";
    public static final String RESOURCE_CATALYST = "X";
    public static final String RESOURCE_GHODIUM = "G";

    public static final String RESOURCE_HYDROXIDE = "OH";
    public static final String RESOURCE_ZYNTHIUM_KEANITE = "ZK";
    public static final String RESOURCE_UTRIUM_LEMERGITE = "UL";

    public static final String RESOURCE_UTRIUM_HYDRIDE = "UH";
    public static final String RESOURCE_UTRIUM_OXIDE = "UO";
    public static final String RESOURCE_KEANIUM_HYDRIDE = "KH";
    public static final String RESOURCE_KEANIUM_OXIDE = "KO";
    public static final String RESOURCE_LEMERGIUM_HYDRIDE = "LH";
    public static final String RESOURCE_LEMERGIUM_OXIDE = "LO";
    public static final String RESOURCE_ZYNTHIUM_HYDRIDE = "ZH";
    public static final String RESOURCE_ZYNTHIUM_OXIDE = "ZO";
    public static final String RESOURCE_GHODIUM_HYDRIDE = "GH";
    public static final String RESOURCE_GHODIUM_OXIDE = "GO";

    public static final String RESOURCE_UTRIUM_ACID = "UH2O";
    public static final String RESOURCE_UTRIUM_ALKALIDE = "UHO2";
    public static final String RESOURCE_KEANIUM_ACID = "KH2O";
    public static final String RESOURCE_KEANIUM_ALKALIDE = "KHO2";
    public static final String RESOURCE_LEMERGIUM_ACID = "LH2O";
    public static final String RESOURCE_LEMERGIUM_ALKALIDE = "LHO2";
    public static final String RESOURCE_ZYNTHIUM_ACID = "ZH2O";
    public static final String RESOURCE_ZYNTHIUM_ALKALIDE = "ZHO2";
    public static final String RESOURCE_GHODIUM_ACID = "GH2O";
    public static final String RESOURCE_GHODIUM_ALKALIDE = "GHO2";

    public static final String RESOURCE_CATALYZED_UTRIUM_ACID = "XUH2O";
    public static final String RESOURCE_CATALYZED_UTRIUM_ALKALIDE = "XUHO2";
    public static final String RESOURCE_CATALYZED_KEANIUM_ACID = "XKH2O";
    public static final String RESOURCE_CATALYZED_KEANIUM_ALKALIDE = "XKHO2";
    public static final String RESOURCE_CATALYZED_LEMERGIUM_ACID = "XLH2O";
}
