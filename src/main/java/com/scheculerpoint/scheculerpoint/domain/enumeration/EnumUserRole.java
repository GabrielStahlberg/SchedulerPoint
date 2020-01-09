package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumUserRole {
    ADMIN("Administrator"),
    USER("User");

    private final String value;

    EnumUserRole(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
