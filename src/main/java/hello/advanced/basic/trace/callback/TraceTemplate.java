package hello.advanced.basic.trace.callback;

import hello.advanced.basic.trace.TraceStatus;
import hello.advanced.basic.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplate {
	private final LogTrace trace;

	public <T> T execute(String message, TraceCallback<T> callback) {
		TraceStatus status = null;
		try {
			status = trace.begin(message); //로직 호출
			T result = callback.call();
			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
