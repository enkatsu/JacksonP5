package org.enkatsu.jacksonp5;

import processing.core.*;
import processing.data.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonP5 {
    PApplet app;
    ObjectMapper mapper;

    public JacksonP5(PApplet app) {
        this.app = app;
        this.mapper = new ObjectMapper();
    }

    public <T extends JacksonP5Object> T readValue(JSONObject json, Class<T> clazz) {
        return readValue(json.toString(), clazz);
    }

    public <T extends JacksonP5Object> T readValue(String json, Class<T> clazz) {
        try {
            T instance = mapper.readValue(json, clazz);
            instance.setApp(app);
            return instance;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
