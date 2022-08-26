package github.polarisink.handler;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.Address;
import io.vertx.up.annotations.EndPoint;
import io.vertx.up.commune.Envelop;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class CallbackHandler {
  /**
   * 生产者
   *
   * @return
   */
  @Path("/callback")
  @POST
  @Address("ZERO://CALLBACK")
  public JsonObject sayCallback(@BodyParam final JsonObject data) {
    return data;
  }

  /**
   * 消费者
   *
   * @param message
   */
  @Address("ZERO://CALLBACK")
  public void replyCallback(final Message<Envelop> message) {
    System.out.println("Callback Success");
    message.reply(Envelop.success("Callback Success"));
  }
}
