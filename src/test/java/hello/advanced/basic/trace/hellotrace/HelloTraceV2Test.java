package hello.advanced.basic.trace.hellotrace;

import hello.advanced.basic.trace.TraceStatus;
import hello.advanced.basic.trace.hellotrace.HelloTraceV2;

import org.junit.jupiter.api.Test;

class HelloTraceV2Test {
    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");

        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}