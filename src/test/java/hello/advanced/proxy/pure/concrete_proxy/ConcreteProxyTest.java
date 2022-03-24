package hello.advanced.proxy.pure.concrete_proxy;

import org.junit.jupiter.api.Test;

import hello.advanced.proxy.pure.concrete_proxy.code.ConcreteClient;
import hello.advanced.proxy.pure.concrete_proxy.code.ConcreteLogic;
import hello.advanced.proxy.pure.concrete_proxy.code.TimeProxy;

class ConcreteProxyTest {
	@Test
	void noProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		ConcreteClient client = new ConcreteClient(concreteLogic);
		client.execute();
	}

	@Test
	void addProxy() {
		ConcreteLogic concreteLogic = new ConcreteLogic();
		TimeProxy timeProxy = new TimeProxy(concreteLogic);
		ConcreteClient client = new ConcreteClient(timeProxy);
		client.execute();
	}
}
