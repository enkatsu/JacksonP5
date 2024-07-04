import org.enkatsu.jacksonp5.*;
import com.fasterxml.jackson.annotation.JsonProperty;

JacksonP5 jacksonp5;
Ball ball;

void setup() {
  size(600, 600);
  JSONObject json = new JSONObject();
  json.setFloat("x", 100.0);
  json.setFloat("y", 200.0);
  json.setFloat("r", 50.0);
  
  jacksonp5 = new JacksonP5(this);
  ball = jacksonp5.readValue(json, Ball.class);
}
void draw() {
  background(100);
  ball.draw();
}

static class Ball extends JacksonP5Object {
  @JsonProperty("x")
  float x;
  @JsonProperty("y")
  float y;
  @JsonProperty("r")
  float r;
  
  void draw() {
    app.noStroke();
    app.fill(100, 200, 250);
    app.ellipse(x, y, r * 2, r * 2);
  }
}
