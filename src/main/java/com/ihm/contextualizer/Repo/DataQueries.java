package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.MongoConfiguration;
import com.ihm.contextualizer.comm.Data;
import com.ihm.contextualizer.comm.adapters.IgnitionRest.IgnitionRestAdp;
import com.ihm.contextualizer.node.Attribute;
import com.ihm.contextualizer.node.Node;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.net.MalformedURLException;
import java.util.List;

public class DataQueries {

    public Data getAttributeData(Attribute at) throws MalformedURLException {
        if (at.getSource().equalsIgnoreCase("IgnitionRestAdp")) {
            IgnitionRestAdp ira = new IgnitionRestAdp();
            return ira.getValue(at.getQuery());

        } else {
            return null;
        }
    }
}
