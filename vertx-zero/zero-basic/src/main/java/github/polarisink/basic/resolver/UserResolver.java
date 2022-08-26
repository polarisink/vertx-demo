package github.polarisink.basic.resolver;

import github.polarisink.basic.entity.PojoUser;
import io.vertx.ext.web.RoutingContext;
import io.vertx.up.atom.Epsilon;
import io.vertx.up.exception.web._400BadRequestException;
import io.vertx.up.uca.rs.mime.Resolver;
import io.vertx.up.unity.Ux;
import io.vertx.up.util.Ut;

/**
 * 只做入参之前的格式化、默认值等处理<br/>
 * Resolver中千万不要调用RoutingContext中HttpServerResponse响应客户端的方法<br/>
 * 如果调用了该方法，会导致主代码逻辑中的内容失效<br/>
 * Resolver的构造函数必须是无参构造函数，否则会初始化不成功引起异常<br/>
 * 相当于动态DefaultValue, 会导致默认值失效
 * @author hzsk
 */
public class UserResolver implements Resolver<PojoUser> {
    @Override
    public Epsilon<PojoUser> resolve(
            final RoutingContext context,
            final Epsilon<PojoUser> income) {
        /*
         * 在您的方法中定义的 @BodyParam 类型
         */
        if (PojoUser.class != income.getArgType()) {
            /*
             * 常用 400
             */
            throw new _400BadRequestException(this.getClass());
        } else {
            final String content = context.getBodyAsString();
            /*
             * 执行转换，Resolver的核心逻辑
             */
            PojoUser user = new PojoUser();
            user.setEmail("lang.yu@hpe.com");
            if (Ut.notNil(content)) {
                user = Ux.fromJson(Ut.toJObject(content), PojoUser.class);
            }
            income.setValue(user);
            return income;
        }
    }
}