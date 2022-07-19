package hello.advanced.proxy.config.v4_postprocessor;

import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import hello.advanced.proxy.config.v3_proxy_factory.advice.LogTraceAdvice;
import hello.advanced.proxy.config.v4_postprocessor.postprocessor.PackageLogTracePostProcessor;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {
	@Bean
	public PackageLogTracePostProcessor logTracePostProcessor(LogTrace logTrace) {
		return new PackageLogTracePostProcessor(
			"hello.advanced.proxy.app",
			getAdvisor(logTrace)
		);
	}

	private Advisor getAdvisor(LogTrace logTrace) {
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedNames("request*", "order*", "save*");

		LogTraceAdvice advice = new LogTraceAdvice(logTrace);
		return new DefaultPointcutAdvisor(pointcut, advice);
	}
}
