package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumUserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    EnumUserRole(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
