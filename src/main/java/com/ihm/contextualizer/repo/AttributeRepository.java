package com.ihm.contextualizer.repo;

import com.ihm.contextualizer.node.Attribute;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface AttributeRepository extends MongoRepository<Attribute,String> {
    //db.node.find({"_id":ObjectId("6323b94f02e92074460b7563")},{"Attributes":{$elemMatch:{Name:"peso"}}},{"_id":0,"Attributes.$":1})


}
