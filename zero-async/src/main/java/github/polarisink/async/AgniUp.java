package github.polarisink.async;

import io.vertx.up.VertxApplication;
import io.vertx.up.annotations.Up;

/**
 * @author hzsk
 */
@Up
public class AgniUp {
    public static void main(final String[] args) {
        VertxApplication.run(AgniUp.class);
    }
}