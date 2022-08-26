
package github.polarisink.async.basic.params;

import io.vertx.core.http.Cookie;
import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * TODO 暂时不使用
 * @author hzsk
 */
@EndPoint
public class CookieAgent {

    @GET
    @Path("/hi/jsr311/cookie")
    public JsonObject sayCookie(@CookieParam("vertx") final String cookie,
                                @CookieParam("vertx") final Cookie cookieOjb) {
        return new JsonObject().put("first", cookie)
                .put("second", new JsonObject()
                        .put("name", cookieOjb.getName())
                        .put("value", cookieOjb.getValue()));
    }
}