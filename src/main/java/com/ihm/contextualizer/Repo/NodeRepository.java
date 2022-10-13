package com.ihm.contextualizer.Repo;

import com.ihm.contextualizer.node.Attribute;
import com.ihm.contextualizer.node.Node;
import com.ihm.contextualizer.node.NodeType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NodeRepository  extends MongoRepository<Node,String> {
    Node getNodeById(String nodeId);

    @Query("{ 'Type' : ?0 }")
    List<Node> findNodesByType(NodeType type);

}
