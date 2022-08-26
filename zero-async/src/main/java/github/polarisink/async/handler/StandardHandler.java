package github.polarisink.async.handler;

import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.Address;
import io.vertx.up.annotations.EndPoint;
import io.vertx.up.commune.Envelop;
import io.vertx.up.unity.Ux;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class StandardHandler {
  /**
   * 生产者
   *
   * @param json
   * @return
   */
  @POST
  @Path("/async")
  @Address("ZERO://ASYNC")
  public String sendAsync(
      @BodyParam final JsonObject json) {
    return json.encode();
  }
  /**
   * 消费者
   *
   * @param message
   */
  @Address("ZERO://ASYNC")
  public Envelop replyAsync(final Envelop message) {
    final JsonObject data = Ux.getJson(message);
    // Do somethings
    return Envelop.success(data);
  }
}
