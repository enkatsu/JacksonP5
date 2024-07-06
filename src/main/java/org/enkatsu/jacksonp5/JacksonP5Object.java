package org.enkatsu.jacksonp5;

import processing.data.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import processing.core.*;

public class JacksonP5Object {
    protected PApplet app;
    protected ObjectMapper mapper;
    
    @JsonIgnore
    void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @JsonIgnore
    void setApp(PApplet app) {
        this.app = app;
    }

    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public JSONObject toJSONObject() {
        try {
            return app.parseJSONObject(mapper.writeValueAsString(this));
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
