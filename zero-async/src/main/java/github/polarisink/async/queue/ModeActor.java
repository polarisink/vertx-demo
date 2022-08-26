package github.polarisink.async.queue;

import io.vertx.up.annotations.Address;
import io.vertx.up.annotations.Queue;
import io.vertx.up.commune.Envelop;
import io.vertx.up.unity.Ux;

@Queue
public class ModeActor {
  @Address("ZERO://ONE-WAY")
  public void hiWorker(final Envelop envelop) {
    final String strData = Ux.getString(envelop);
    System.out.println("one way");
    System.out.println(strData);
  }

  @Address("ZERO://ASYNC")
  public void async(final Envelop envelop) {
    final String strData = Ux.getString(envelop);
    System.out.println("async");
    System.out.println(strData);
  }

  @Address("ZERO://CALLBACK")
  public void callback(final Envelop envelop) {
    final String strData = Ux.getString(envelop);
    System.out.println("callback");
    System.out.println(strData);
  }
}