package com.jwt.jwtUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static  String objToJsonString(Object object) throws JsonProcessingException {


        return new ObjectMapper().writeValueAsString(object);
    }
}
