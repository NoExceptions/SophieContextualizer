package com.ihm.contextualizer.repo;


import com.ihm.contextualizer.node.Node;

import com.ihm.contextualizer.node.NodeType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface NodeRepository  extends MongoRepository<Node,String> {

    @Query("{ 'Type' : ?0 }")
    List<Node> findNodesByType(NodeType type);


}
