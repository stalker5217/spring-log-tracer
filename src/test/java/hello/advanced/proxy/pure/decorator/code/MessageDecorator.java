package hello.advanced.proxy.pure.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {
	private final Component component;

	public MessageDecorator(Component component) {
		this.component = component;
	}

	@Override
	public String operation() {
		log.info("Message Decorator 실행");

		String result = component.operation();
		String decoResult = "*****" + result + "*****";
		log.info("Message Decorator 꾸미기 전: {}", result);
		log.info("Message Decorator 꾸미기 후: {}", decoResult);

		return decoResult;
	}
}
