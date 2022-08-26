package github.polarisink.async.basic.params;

import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 * 路径前缀和header
 * @author hzsk
 */
@Path("/prefix")
@EndPoint
public class HeaderAgent {

    @GET
    @Path("/hi/param/header-value")
    public JsonObject sayBody(@HeaderParam("X-Sigma") final String sigma,
                              @HeaderParam("Authorization") final String authorization) {
        return new JsonObject().put("sigma", sigma).put("authorization", authorization);
    }
}