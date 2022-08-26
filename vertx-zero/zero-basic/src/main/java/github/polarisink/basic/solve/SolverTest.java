package github.polarisink.basic.solve;

import github.polarisink.basic.entity.PojoUser;
import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class SolverTest {
  @POST
  @Path("/hi/jsr311/resolver-small")
  public JsonObject setSolve(@BodyParam(resolver = UserSolve.class) final PojoUser user) {
    return new JsonObject().put("content", user.toString());
  }
}
