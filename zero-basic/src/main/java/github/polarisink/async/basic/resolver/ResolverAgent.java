package github.polarisink.async.basic.resolver;

import github.polarisink.async.basic.entity.PojoUser;
import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 参数处理器的使用
 * 会导致默认值失效
 *
 * @author hzsk
 */
@EndPoint
public class ResolverAgent {

  @POST
  @Path("/hi/jsr311/resolver")
  public JsonObject sayResolver(@BodyParam(resolver = UserResolver.class) final PojoUser user) {
    return new JsonObject().put("content", user.toString());
  }
}