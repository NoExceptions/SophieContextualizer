package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.node.Attribute;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends ReactiveMongoRepository<Attribute,String>{
    //db.node.find({"_id":ObjectId("6323b94f02e92074460b7563")},{"Attributes":{$elemMatch:{Name:"peso"}}},{"_id":0,"Attributes.$":1})


}
