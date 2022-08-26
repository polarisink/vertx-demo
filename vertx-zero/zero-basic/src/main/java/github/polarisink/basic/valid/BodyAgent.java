package github.polarisink.basic.valid;

import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.Codex;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * CodeX高级校验,作用于复杂数据结构
 *
 * @author hzsk
 */
@EndPoint
@Path("/hi/jsr303")
public class BodyAgent {

  @POST
  @Path("/advanced")
  public JsonObject testCodex(@BodyParam @Codex final JsonObject user) {
    return user;
  }
}