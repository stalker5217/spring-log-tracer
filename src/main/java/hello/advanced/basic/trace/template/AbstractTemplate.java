package hello.advanced.basic.trace.template;

import hello.advanced.basic.trace.TraceStatus;
import hello.advanced.basic.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {
	private final LogTrace trace;

	public T execute(String message) {
		TraceStatus status = null;
		try {
			status = trace.begin(message); //로직 호출
			T result = call();
			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	protected abstract T call();
}
