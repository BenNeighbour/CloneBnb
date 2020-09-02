package com.benneighbour.CloneBnb.commonlibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Ben Neighbour
 * @created 02/09/2020
 * @project CloneBnb
 */
public class MessageConverter {
    public static ObjectMapper mapper = new ObjectMapper();

    public static <T> String encode(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T> T decode(String in, Class<?> cn) throws IOException {
        return (T) mapper.readValue(in, cn);
    }
}
