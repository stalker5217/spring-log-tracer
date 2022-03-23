package hello.advanced.basic.app.v5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;

@RestController
public class OrderControllerV5 {
	private final OrderServiceV5 orderService;
	private final TraceTemplate template;

	public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
		this.orderService = orderService;
		this.template = new TraceTemplate(logTrace);
	}

	@GetMapping("/v5/request")
	public String request(String itemId) {
		return template.execute("OrderController.request()", () -> {
			orderService.orderItem(itemId);
			return "ok";
		});
	}
}
