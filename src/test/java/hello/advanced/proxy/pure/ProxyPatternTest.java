package hello.advanced.proxy.pure;

import org.junit.jupiter.api.Test;

import hello.advanced.proxy.pure.code.CacheProxy;
import hello.advanced.proxy.pure.code.ProxyPatternClient;
import hello.advanced.proxy.pure.code.RealSubject;

class ProxyPatternTest {
	@Test
	void noProxyTest() {
		RealSubject realSubject = new RealSubject();
		ProxyPatternClient client = new ProxyPatternClient(realSubject);

		client.execute();
		client.execute();
		client.execute();
	}

	@Test
	void cacheProxyTest() {
		RealSubject realSubject = new RealSubject();
		CacheProxy cacheProxy = new CacheProxy(realSubject);
		ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

		client.execute();
		client.execute();
		client.execute();
	}
}
