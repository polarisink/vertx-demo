package github.polarisink.basic.params;

import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class HiAgent {
  @GET
  @Path("/hi/zero-string")
  public String sayHello() {
    return "Hello Zero";
  }

  @GET
  @Path("/hi/zero-json")
  public JsonObject sayHelloJ() {
    return new JsonObject().put("message", "Hello Zero");
  }
}
