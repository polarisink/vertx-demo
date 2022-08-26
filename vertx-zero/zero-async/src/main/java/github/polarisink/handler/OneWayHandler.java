package github.polarisink.handler;

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
public class OneWayHandler {
  /**
   * 生产者
   *
   * @param json
   * @return
   */
  @POST
  @Path("/one-way")
  @Address("ZERO://ONE-WAY")
  public String sendOneWay(@BodyParam final JsonObject json) {
    return json.encode();
  }

  /**
   * 消费者
   *
   * @param message
   */
  @Address("ZERO://ONE-WAY")
  public void reply(final Envelop message) {
    final JsonObject data = Ux.getJson(message);
    System.out.println("消费者开始消费");
    // Do somethings
    System.out.println(data.encodePrettily());
  }
}
