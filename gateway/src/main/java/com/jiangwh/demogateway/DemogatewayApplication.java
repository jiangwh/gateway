package com.jiangwh.demogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@RestController
@SpringBootApplication
public class DemogatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemogatewayApplication.class, args);
	}

	@RequestMapping("/hystrixfallback")
	public String hystrixfallback() {
		return "This is a fallback";
	}


	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route("path_route", r -> r.path("/get")
						.uri("http://httpbin.org"))
				.route("host_route", r -> r.host("*.myhost.org")
						.uri("http://httpbin.org"))
				.route("rewrite_route", r -> r.host("*.rewrite.org")
						.filters(f -> f.rewritePath("/foo/(?<segment>.*)",
								"/${segment}"))
						.uri("http://httpbin.org"))
				.route("hystrix_route", r -> r.host("*.hystrix.org")
						.filters(f -> f.hystrix(c -> c.setName("slowcmd")))
								.uri("http://httpbin.org"))
				.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
						.filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
								.uri("http://httpbin.org"))
//				.route("limit_route", r -> r
//					.host("*.limited.org").and().path("/anything/**")
//						.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//					.uri("http://httpbin.org"))
				.route("websocket_route", r -> r.path("/echo")
					.uri("ws://localhost:9000"))
				.build();
		//@formatter:on
	}

//	@Bean
//	RedisRateLimiter redisRateLimiter() {
//		return new RedisRateLimiter(1, 2);
//	}

	@Bean("MyRateLimiter")
	RateLimiter rateLimiter(){
		return new RateLimiter() {

			@Override
			public Mono<Response> isAllowed(String routeId, String id) {
				return null;
			}

			@Override
			public Map getConfig() {
				return null;
			}

			@Override
			public Class getConfigClass() {
				return null;
			}

			@Override
			public Object newConfig() {
				return null;
			}
		};
	}

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostName());
	}

//	@Bean
//	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
//		return http.httpBasic().and()
//				.csrf().disable()
//				.authorizeExchange()
//				.pathMatchers("/anything/**").authenticated()
//				.anyExchange().permitAll()
//				.and()
//				.build();
//	}
//
//	@Bean
//	public MapReactiveUserDetailsService reactiveUserDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
//		return new MapReactiveUserDetailsService(user);
//	}

}
