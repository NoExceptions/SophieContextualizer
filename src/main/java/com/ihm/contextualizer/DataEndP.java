package com.ihm.contextualizer;

import com.ihm.contextualizer.comm.Data;

import com.ihm.contextualizer.repo.DataQueries;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/data")
public class DataEndP {

    AttrQueries atr = new AttrQueries();
    DataQueries dq = new DataQueries();

    @GetMapping("/getRTValue/{nodeId}/{attribute}")
    public Data getDataForNodeAttribute(@PathVariable String nodeId, @PathVariable String attribute) throws MalformedURLException {
        return dq.getAttributeData(atr.getAttrByNodeAndName(nodeId,attribute).get(0));
    }


}
