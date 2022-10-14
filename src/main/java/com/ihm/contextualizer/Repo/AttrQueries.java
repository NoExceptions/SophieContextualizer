package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.MongoConfiguration;
import com.ihm.contextualizer.node.Attribute;
import com.ihm.contextualizer.node.Node;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AttrQueries {

    @Autowired
    private ReactiveMongoTemplate mt = new MongoConfiguration().reactiveMongoTemplate();

    public Mono<Attribute> getAttrByNodeAndName(String nodeId, String Name){

        Query query = new Query();
        Criteria findc = Criteria.where("_id").is(new ObjectId(nodeId)).and("Attributes").elemMatch(Criteria.where("Name").is(Name));
        query.addCriteria(findc);
        Flux<Node> ans = mt.find(query,Node.class);

        return ans.hasElements().map(isAvailable -> {

            if (isAvailable) {
                return ans.blockLast().getAttributes().get(0);
            } else {
                return null;
            }
        });

    }
}
