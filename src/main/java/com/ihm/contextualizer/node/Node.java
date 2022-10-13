package com.ihm.contextualizer.node;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document
public class Node {
    
    @Id
    String id;


    @DocumentReference
    List<Node> Children = null;
    String Name = null;
    NodeType Type = null;
    List<Attribute> Attributes = null;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date LastModifiedDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Node> getChildren() {
        return Children;
    }

    public void setChildren(List<Node> children) {
        Children = children;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public NodeType getType() {
        return Type;
    }

    public void setType(NodeType type) {
        Type = type;
    }
    public List<Attribute> getAttributes() {
        return Attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        Attributes = attributes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }
}
