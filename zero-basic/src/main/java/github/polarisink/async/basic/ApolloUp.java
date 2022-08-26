package github.polarisink.async.basic;

import io.vertx.up.VertxApplication;
import io.vertx.up.annotations.Up;

/**
 * @author hzsk
 */
@Up
public class ApolloUp {

    public static void main(final String[] args) {
        VertxApplication.run(ApolloUp.class);
    }
}