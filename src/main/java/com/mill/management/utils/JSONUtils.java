package com.mill.management.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class JSONUtils {

    public static JSONObject filterJsonObject(Object aClass, List<String> removeFields) throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper =new ObjectMapper();
        String json = objectMapper.writeValueAsString(aClass);

        System.err.print(json);

        JSONObject jsonObject = new JSONObject(json);
        for(String field:removeFields){
            jsonObject.remove(field);
        }
        return jsonObject;
    }

}
