package hello.advanced.proxy.pure.decorator;

import org.junit.jupiter.api.Test;

import hello.advanced.proxy.pure.decorator.code.Component;
import hello.advanced.proxy.pure.decorator.code.DecoratorPatternClient;
import hello.advanced.proxy.pure.decorator.code.MessageDecorator;
import hello.advanced.proxy.pure.decorator.code.RealComponent;
import hello.advanced.proxy.pure.decorator.code.TimeDecorator;

public class DecoratorPatternTest {
	@Test
	void noDecorator() {
		Component realComponent = new RealComponent();
		DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
		client.execute();
	}

	@Test
	void decorator1() {
		Component realComponent = new RealComponent();
		Component messageDecorator = new MessageDecorator(realComponent);
		DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

		client.execute();
	}

	@Test
	void decorator2() {
		Component realComponent = new RealComponent();
		Component messageDecorator = new MessageDecorator(realComponent);
		Component timeDecorator = new TimeDecorator(messageDecorator);
		DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

		client.execute();
	}
}
