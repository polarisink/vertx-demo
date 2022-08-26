package github.polarisink.handler;

import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * 不能无参返回
 * 不能使用@Address
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class SyncHandler {
  @GET
  @Path("/sync")
  public String doSync(
      @QueryParam("name") final String name
  ) {
    return "Hi + " + name;
  }
}
