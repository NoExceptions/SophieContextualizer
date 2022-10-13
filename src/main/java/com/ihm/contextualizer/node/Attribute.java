package com.ihm.contextualizer.node;

public class Attribute {


    String Source;
    String Query;
    String Name;
    String EU;
    ValueType Type;


    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEU() {
        return EU;
    }

    public void setEU(String EU) {
        this.EU = EU;
    }

    public ValueType getType() {
        return Type;
    }

    public void setType(ValueType type) {
        Type = type;
    }

}
