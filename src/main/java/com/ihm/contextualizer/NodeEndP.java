package com.ihm.contextualizer;

import com.ihm.contextualizer.node.NodeType;
import com.ihm.contextualizer.node.Node;

import com.ihm.contextualizer.Repo.NodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nodes")
public class NodeEndP {

    @Autowired
    NodeRepository nodeRepository;

    @GetMapping(value = "/")
    public Flux<Node> getAllNodes() {
        return nodeRepository.findAll();
    }
    @GetMapping(value = "/{nodeId}")
    public Node getNodeById(@PathVariable String nodeId) {
        return nodeRepository.findById(nodeId).block();
    }

    @GetMapping(value = "/architecture")
    public Node getNodeByType() {

        return nodeRepository.findNodesByType(NodeType.COORP).block();
    }

    @PostMapping(value = "/create")
    public Mono<Node> addNode(@RequestBody Flux<Node> node) {
        return nodeRepository.save(node.blockLast());
    }


}
