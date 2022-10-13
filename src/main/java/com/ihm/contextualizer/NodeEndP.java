package com.ihm.contextualizer;

import com.ihm.contextualizer.node.NodeType;
import com.ihm.contextualizer.node.Node;
import com.ihm.contextualizer.node.ValueType;
import com.ihm.contextualizer.Repo.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nodes")
public class NodeEndP {

    @Autowired
    NodeRepository nodeRepository;

    @GetMapping(value = "/")
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }
    @GetMapping(value = "/{nodeId}")
    public Node getNodeById(@PathVariable String nodeId) {
        return nodeRepository.getNodeById(nodeId);
    }

    @GetMapping(value = "/architecture")
    public List<Node> getNodeByType() {
        return nodeRepository.findNodesByType(NodeType.COORP);
    }

    @PostMapping(value = "/create")
    public Node addNode(@RequestBody Node node) {
        return nodeRepository.save(node);
    }


}
