package com.ihm.contextualizer.comm.adapters.IgnitionRest;

import com.google.gson.Gson;
import com.ihm.contextualizer.comm.Data;
import com.ihm.contextualizer.comm.adapters.commAdapter;
import com.ihm.contextualizer.node.ValueType;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Locale;

public class IgnitionRestAdp implements commAdapter {

    @Override
    public String getName() {
        return "IgnitionRestAdp";
    }

    @Override
    public Data getValue(String Query) throws MalformedURLException {
        //source example: https://vendas.ignitionbrasil.com/system/webdev/sn/getRTValue
        //Query example: {"tags":["[default]Random/RandomInteger2","[default]Ramp/Ramp3"]} <---> json with tags array
        RestTemplate rt = new RestTemplate();
        //String my_scheme = (Source.split(":")[0].toLowerCase()=="https") ? "https" : "http";
        String Source = Query.split("\\|")[0];
        String Tags = Query.split("\\|")[1];
        //JSONObject request = new JSONObject(Query);
        URL url = new URL(Source);
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(url.getProtocol())
                .host(url.getHost())
                .path(url.getPath())
                .build();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(Tags, header);
        ResponseEntity<Tag[]> response = rt.postForEntity(uri.toUriString(), request,Tag[].class);
        Data ans = new Data(Source,Query);
        ans.setValue(response.getBody()[0]);
        ans.setTimestamp(new Date());
        ans.setType(ValueType.DOCUMENT);
        return ans;
    }
}
