package hello.advanced.basic.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.basic.strategy.code.Strategy;
import hello.advanced.basic.strategy.code.ContextV2;
import hello.advanced.basic.strategy.code.StrategyLogic1;
import hello.advanced.basic.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ContextV2Test {
	/**
	 * 전략 패턴 적용
	 */
	@Test
	void strategyV1() {
		ContextV2 context = new ContextV2();
		context.execute(new StrategyLogic1());
		context.execute(new StrategyLogic2());
	}

	@Test
	void strategyV2() {
		ContextV2 context = new ContextV2();
		context.execute(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
		context.execute(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
	}

	@Test
	void strategyV3() {
		ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 로직1 실행"));
		context.execute(() -> log.info("비즈니스 로직2 실행"));
	}
}
