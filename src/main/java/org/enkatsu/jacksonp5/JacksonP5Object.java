package org.enkatsu.jacksonp5;

import com.fasterxml.jackson.annotation.JsonIgnore;

import processing.core.*;

public class JacksonP5Object {
    protected PApplet app;
    
    @JsonIgnore
    void setApp(PApplet app) {
        this.app = app;
    }
}
