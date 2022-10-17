package com.ihm.contextualizer;

import com.ihm.contextualizer.node.NodeType;
import com.ihm.contextualizer.node.Node;

import com.ihm.contextualizer.repo.NodeQueries;
import com.ihm.contextualizer.repo.NodeRepository;
import com.ihm.contextualizer.responses.MyResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/nodes")
public class NodeEndP {

    @Autowired
    NodeRepository nodeRepository;

    @Operation(summary = "Get all nodes")
    @GetMapping(value = "/")
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }

    @Operation(summary = "Get nodes aggregated by a type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nodes found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Node[].class)) }),
            @ApiResponse(responseCode = "422", description = "Bad request syntax",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Any node found",
                    content = @Content) })
    @GetMapping(value = "/byType")
    public List<Node> getNodesByType(@Parameter(description = "Type of node you are searching") @RequestParam() String type) {
        try {
            NodeType nodeType = NodeType.valueOf(type.toUpperCase(Locale.ROOT));
            List<Node> ans = nodeRepository.findNodesByType(nodeType);

            if (ans.size() <= 0){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No nodes found with the requested type", new MyResourceNotFoundException());
            }
            else {
                return ans;
            }
        }
        catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Bad request syntax.", ex);
        }
    }


    @Operation(summary = "Get a node by it's Id")
    @GetMapping(value = "/{nodeId}")
    public Optional<Node> getNodeById(@PathVariable String nodeId) {
        return nodeRepository.findById(nodeId);
    }

    @Operation(summary = "Get entire Architecture of this specific contextualizer from ROOT.")
    @GetMapping(value = "/getArchitecture")
    public List<Node> getNodeByType() {
        NodeQueries nq = new NodeQueries();
        return nq.getNodesByType(NodeType.COORP);
    }

    @PostMapping(value = "/create")
    public Node addNode(@RequestBody Node node) {
        return nodeRepository.save(node);
    }

    @Operation(summary = "Update specific Node by a given Node Id. NodeId and Type are mandatory, other attributes will be discarded when empty")
    @PutMapping("/")
    Node replaceNode(@Valid @RequestBody Node newNode) {

        return nodeRepository.findById(newNode.getId())
                .map(node -> {
                    node.setName(newNode.getName());
                    node.setType(newNode.getType());
                    if (!newNode.getAttributes().isEmpty()) {
                        node.setAttributes(newNode.getAttributes());
                    }
                    if (!newNode.getChildren().isEmpty()) {
                        node.setChildren(newNode.getChildren());
                    }

                    return nodeRepository.save(node);
                })
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "No node to update found with the requested Id", new MyResourceNotFoundException())
                );
    }

}
