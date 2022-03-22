package hello.advanced.proxy.pure.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{
	private final Component component;

	public TimeDecorator(Component component) {
		this.component = component;
	}

	@Override
	public String operation() {
		log.info("Time Decorator 실행");
		long startTime = System.currentTimeMillis();

		String result = component.operation();

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("실행 시간: {}ms", resultTime);

		return result;
	}
}
