import org.enkatsu.jacksonp5.*;
import com.fasterxml.jackson.annotation.JsonProperty;

JacksonP5 jacksonp5;
Ball ball;

String json = """
{
  "x": 100.0,
  "y": 200.0,
  "r": 50.0
}
""";

void setup() {
  size(600, 600);
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
