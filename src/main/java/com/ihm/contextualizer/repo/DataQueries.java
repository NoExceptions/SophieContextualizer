package com.ihm.contextualizer.repo;


import com.ihm.contextualizer.comm.Data;
import com.ihm.contextualizer.comm.adapters.IgnitionRest.IgnitionRestAdp;
import com.ihm.contextualizer.node.Attribute;


import java.net.MalformedURLException;

public class DataQueries {

    public Data getAttributeData(Attribute at) throws MalformedURLException {
        if (at.getSource().equalsIgnoreCase("IgnitionRestAdp")) {
            IgnitionRestAdp ira = new IgnitionRestAdp();
            return ira.getValue(at.getQuery());

        } else {
            return null;
        }
    }
}
