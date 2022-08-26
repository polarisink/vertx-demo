package github.polarisink.basic.params;

import io.vertx.up.annotations.EndPoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author aries
 * @date 2022/8/25
 */
@EndPoint
public class PathTest {
  /**
   * 路径变量获取参数,vertx原生支持
   * @param id
   * @return
   */
  @GET
  @Path("/get/:id")
  public String pathValue(@PathParam("id") final String id) {
    return "通过id获取: " + id;
  }

  /**
   * Spring框架和JSR311中的常用格式,vertx原生不支持，zero支持
   * @param email
   * @return
   */
  @GET
  @Path("/get/email/{email}")
  public String sayEmail(@PathParam("email") final String email) {
    return "Hi , the Email is " + email;
  }
}
