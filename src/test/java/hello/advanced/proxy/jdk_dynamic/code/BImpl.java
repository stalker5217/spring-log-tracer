package hello.advanced.proxy.jdk_dynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{
	@Override
	public String call() {
		log.info("call B");
		return "B";
	}
}
