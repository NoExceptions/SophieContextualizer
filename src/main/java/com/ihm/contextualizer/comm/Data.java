package com.ihm.contextualizer.comm;



import com.ihm.contextualizer.node.ValueType;

import java.util.Date;

public class Data {

    Object value;
    ValueType type;
    String source,query;
    Date timestamp;

    public Data(String source,String query) {
        this.source = source;
        this.query = query;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


}
