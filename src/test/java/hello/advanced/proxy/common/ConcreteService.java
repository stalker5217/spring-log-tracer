package hello.advanced.proxy.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {
	public void call() {
		log.info("concrete service call 호출");
	}
}
