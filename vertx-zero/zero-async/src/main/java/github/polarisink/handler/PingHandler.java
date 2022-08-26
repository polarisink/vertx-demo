package github.polarisink.handler;

import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * 必须返回void
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class PingHandler {
  @GET
  @Path("/ping/{name}")
  public void doPing(
      @PathParam("name") final String name) {
    System.out.println("Ping Request");
  }
}
