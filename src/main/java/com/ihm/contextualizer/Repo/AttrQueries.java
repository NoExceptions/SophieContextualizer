package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.MongoConfiguration;
import com.ihm.contextualizer.node.Attribute;
import com.ihm.contextualizer.node.Node;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;

public class AttrQueries {

    @Autowired
    private MongoTemplate mt = new MongoConfiguration().mongoTemplate();

    public Attribute getAttrByNodeAndName(String nodeId, String Name){

        Query query = new Query();
        Criteria findc = Criteria.where("_id").is(new ObjectId(nodeId)).and("Attributes").elemMatch(Criteria.where("Name").is(Name));
        query.addCriteria(findc);
        List<Node> ans = mt.find(query,Node.class);
        if(ans.size() > 0)
        {
            Attribute att = ans.get(0).getAttributes().get(0);
            return att;
        }
        else {
            return  null;
        }
    }
}
