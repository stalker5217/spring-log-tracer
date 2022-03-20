package hello.advanced.basic.trace.logtrace;

import hello.advanced.basic.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
