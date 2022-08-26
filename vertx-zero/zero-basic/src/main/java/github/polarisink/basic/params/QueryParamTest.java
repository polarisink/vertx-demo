package github.polarisink.basic.params;

import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.BodyParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class QueryParamTest {
  @GET
  @Path("/hi/param/query-string")
  public String sayQuery(@QueryParam("name") final String name) {
    return "Hi " + name;
  }

  @GET
  @Path("/hi/param/query-body")
  public JsonObject sayQBody(@QueryParam("name") final String name, @BodyParam final JsonObject data) {
    return new JsonObject().put("name", name).put("data", data);
  }
}
