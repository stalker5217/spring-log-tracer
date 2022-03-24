package hello.advanced.proxy.pure.concrete_proxy.code;

public class ConcreteClient {
	private final ConcreteLogic concreteLogic;

	public ConcreteClient(ConcreteLogic concreteLogic) {
		this.concreteLogic = concreteLogic;
	}

	public void execute() {
		concreteLogic.operation();
	}
}
