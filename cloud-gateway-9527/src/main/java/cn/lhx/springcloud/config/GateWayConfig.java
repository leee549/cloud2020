package cn.lhx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lee549
 * @date 2020/7/15 22:45
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        routes.route("path_route2",
                r -> r.path("/lady")
                        .uri("http://news.baidu.com/lady"));
        return routes.build();
    }
}
