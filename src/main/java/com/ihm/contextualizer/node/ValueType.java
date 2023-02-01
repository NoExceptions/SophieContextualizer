package com.ihm.contextualizer.node;

public enum ValueType {
    INTEGER("INTEGER"), FLOAT("FLOAT"),STRING("STRING"),TAG("TAG"),DATATABLE("DATATABLE"),DATEANDTIME("DATEANDTIME"),UNKNOWN("UNKNOWN"),DOCUMENT("DOCUMENT");

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
