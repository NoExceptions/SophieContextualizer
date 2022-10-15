package com.ihm.contextualizer;

import com.ihm.contextualizer.node.NodeType;
import com.ihm.contextualizer.node.Node;

import com.ihm.contextualizer.repo.NodeQueries;
import com.ihm.contextualizer.repo.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nodes")
public class NodeEndP {

    @Autowired
    NodeRepository nodeRepository;

    @GetMapping(value = "/")
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }

    @GetMapping(value = "/byType/{mytype}")
    public List<Node> getNodesByType(@PathVariable String mytype) {
        return nodeRepository.findNodesByType(mytype);
    }



    @GetMapping(value = "/{nodeId}")
    public Optional<Node> getNodeById(@PathVariable String nodeId) {
        return nodeRepository.findById(nodeId);
    }

    @GetMapping(value = "/architecture")
    public List<Node> getNodeByType() {
        NodeQueries nq = new NodeQueries();
        return nq.getNodesByType(NodeType.COORP);
    }

    @PostMapping(value = "/create")
    public Node addNode(@RequestBody Node node) {
        return nodeRepository.save(node);
    }


}
