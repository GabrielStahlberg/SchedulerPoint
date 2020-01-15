package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumCardType {
    CR("Crédito"),
    DE("Débito"),
    CD("Crédito/Débito"),
    AL("Alimentação"),
    RE("Refeição");

    private final String value;

    EnumCardType(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
