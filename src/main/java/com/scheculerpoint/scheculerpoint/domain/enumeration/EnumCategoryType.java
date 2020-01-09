package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumCategoryType {
    S("Spent"),
    R("Received");

    private final String value;

    EnumCategoryType(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
