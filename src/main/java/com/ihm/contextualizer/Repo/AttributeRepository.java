package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.node.Attribute;
import com.ihm.contextualizer.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AttributeRepository extends MongoRepository<Attribute,String>{
    //db.node.find({"_id":ObjectId("6323b94f02e92074460b7563")},{"Attributes":{$elemMatch:{Name:"peso"}}},{"_id":0,"Attributes.$":1})


}
