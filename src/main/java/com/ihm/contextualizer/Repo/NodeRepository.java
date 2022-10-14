package com.ihm.contextualizer.Repo;


import com.ihm.contextualizer.node.Node;
import com.ihm.contextualizer.node.NodeType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface NodeRepository  extends ReactiveMongoRepository<Node,String> {


    @Query("{ 'Type' : ?0 }")
    Mono<Node> findNodesByType(NodeType type);

}
