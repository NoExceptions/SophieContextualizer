package com.ihm.contextualizer.node;

public enum ValueType {
    INTEGER("INTEGER"), FLOAT("FLOAT"),STRING("STRING"),DOCUMENT("DOCUMENT"),DATEANDTIME("DATEANDTIME"),UNKNOWN("UNKNOWN");

    private String value;


    ValueType(String value) {
        this.value = value;
    }



    public String toValue() {
        return value;
    }

    public static ValueType getDefault() {
        return UNKNOWN;
    }
}
