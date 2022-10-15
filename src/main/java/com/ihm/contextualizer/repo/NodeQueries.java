package com.ihm.contextualizer.repo;


import com.ihm.contextualizer.MongoConfiguration;
import com.ihm.contextualizer.node.Node;
import com.ihm.contextualizer.node.NodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class NodeQueries {

    private MongoTemplate mt = new MongoConfiguration().mongoTemplate();
    public List<Node> getNodesByType(NodeType nt){

        Query query = new Query();
        Criteria findc = Criteria.where("Type").is(nt.toValue());
        query.addCriteria(findc);
        return mt.find(query,Node.class);
    }

}
