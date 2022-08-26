package github.polarisink.async.basic.params;

import github.polarisink.async.basic.entity.PojoUser;
import io.vertx.core.json.JsonObject;
import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.*;
import java.util.Date;

/**
 * 默认值,支持简单类型
 * @author hzsk
 */
@EndPoint
public class DefaultAgent {
    @GET
    @Path("/hi/jsr311/default")
    public JsonObject sayDefault(@QueryParam("month")
                                 @DefaultValue("13") final Integer month) {
        return new JsonObject().put("month", month);
    }

    @GET
    @Path("/hi/jsr311/default-date")
    public JsonObject sayDate(
            @QueryParam("from") @DefaultValue("2011-08-15") final Date from,
            @QueryParam("to") @DefaultValue("2013-11-11") final Date to) {
        return new JsonObject()
                .put("from", from.toInstant())
                .put("to", to.toInstant());
    }

    @POST
    @Path("/hi/jsr311/default-pojo")
    public JsonObject sayDefault(
        @BodyParam @DefaultValue("{\"username\":\"test\"}") final PojoUser user) {
        return new JsonObject().put("serialized", user.toString());
    }
}