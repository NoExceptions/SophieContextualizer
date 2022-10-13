package com.ihm.contextualizer.node;

public enum NodeType {
    COORP("COORP"),PLANT("PLANT"),AREA("AREA"),LINE("LINE"),EQUIPMENT("EQUIPMENT"),UNKNOWN("UNKNOWN");

    private String value;


    NodeType(String value) {
        this.value = value;
    }



    public String toValue() {
        return value;
    }

    public static NodeType getDefault() {
        return UNKNOWN;
    }
}
