package hello.advanced.basic.app.v2;

import hello.advanced.basic.trace.TraceId;
import hello.advanced.basic.trace.TraceStatus;
import hello.advanced.basic.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        }
        catch(Exception e) {
            trace.exception(status, e);
            throw  e;
        }
    }
}