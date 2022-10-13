package com.ihm.contextualizer.comm.adapters;

import com.ihm.contextualizer.comm.Data;

import java.net.MalformedURLException;

public interface commAdapter {
    String getName();
    Data getValue(String Query) throws Exception;

}
