package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumCardFlag {
    VIS("Visa"),
    MAS("MasterCard"),
    MAE("Maestro"),
    ELO("Elo"),
    RES("RedeShop"),
    SOD("Sodexo"),
    ALE("Alelo"),
    VRE("VR"),
    AME("AmericanExpress");

    private final String value;

    EnumCardFlag(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
