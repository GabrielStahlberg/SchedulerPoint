package com.scheculerpoint.scheculerpoint.domain.enumeration;

public enum EnumGender {
    M("Male"),
    F("Female");

    private final String value;

    EnumGender(String optionValue) {
        value = optionValue;
    }

    public String getValue() {
        return value;
    }
}
