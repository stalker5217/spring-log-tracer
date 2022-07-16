package hello.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import hello.advanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.advanced.proxy.config.v2_dynamic_proxy.DynamicProxyBasicConfig;
import hello.advanced.proxy.config.v2_dynamic_proxy.DynamicProxyFilterConfig;
import hello.advanced.proxy.config.v3_proxy_factory.ProxyFactoryConfigV1;
import hello.advanced.proxy.config.v3_proxy_factory.ProxyFactoryConfigV2;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;

// @Import({AppV1Config.class, AppV2Config.class})
// @Import(InterfaceProxyConfig.class)
// @Import(ConcreteProxyConfig.class)
// @Import(DynamicProxyBasicConfig.class)
// @Import(DynamicProxyFilterConfig.class)
// @Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app")
public class SpringAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
