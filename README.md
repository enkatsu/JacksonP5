# JacksonP5

JacksonP5 is a [Jackson](https://github.com/FasterXML/jackson) wrapper library for Processing.

## What is Jackson?

https://github.com/FasterXML/jackson?tab=readme-ov-file#what-is-jackson

> Jackson has been known as "the Java JSON library" or "the best JSON parser for Java". Or simply as "JSON for Java".
More than that, Jackson is a suite of data-processing tools for Java (and the JVM platform), including the flagship streaming JSON parser / generator library, matching data-binding library (POJOs to and from JSON) and additional data format modules to process data encoded in Avro, BSON, CBOR, CSV, Smile, (Java) Properties, Protobuf, TOML, XML or YAML; and even the large set of data format modules to support data types of widely used data types such as Guava, Joda, PCollections and many, many more (see below).
While the actual core components live under their own projects -- including the three core packages (streaming, databind, annotations); data format libraries; data type libraries; JAX-RS provider; and a miscellaneous set of other extension modules -- this project act as the central hub for linking all the pieces together.
A good companion to this README is the Jackson Project FAQ.

## Installation

Download JacksonP5 from [releases](https://github.com/enkatsu/JacksonP5/releases) and place it in libraries.

## Usage

### Read from String

```java
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
  // Mapping JSON to class
  ball = jacksonp5.readValue(json, Ball.class);
}

void draw() {
  background(100);
  ball.draw();
}

// Must be a static class that extends JacksonP5Object
static class Ball extends JacksonP5Object {
  // Mapping JSON properties to class fields
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
```

### Read from JSONObject

```java
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
```

## License

MIT License
