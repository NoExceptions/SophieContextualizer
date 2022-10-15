package com.ihm.contextualizer;

import com.ihm.contextualizer.repo.AttributeRepository;
import com.ihm.contextualizer.node.Attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Attribute")
public class AttributeEndP {

    @Autowired
    AttributeRepository attrRepository;
    AttrQueries attrQueries = new AttrQueries();
    @GetMapping("/{nodeId}/{attribute}")
    public List<Attribute> getAttrByNodeAndName(@PathVariable String nodeId, @PathVariable String attribute) {
        return attrQueries.getAttrByNodeAndName(nodeId,attribute);
    }


}