package org.mockito.configuration;

import android.support.annotation.NonNull;

import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import io.reactivex.Observable;
import io.reactivex.Single;


/*
https://medium.com/@fabioCollini/testing-asynchronous-rxjava-code-using-mockito-8ad831a16877#.u0ywzy8l7
In this class we define that, when a method returns an Observable (or a Single), the value returned is
an Observable (or a Single) that emits an exception. In this way executing the previous test we get
an exception that says that we need to define the behaviour of a mock (and not a NullPointerException!).
 */
public class MockitoConfiguration extends DefaultMockitoConfiguration {
	public Answer<Object> getDefaultAnswer() {
		return new ReturnsEmptyValues() {
			@Override
			public Object answer(InvocationOnMock inv) {
				Class<?> type = inv.getMethod().getReturnType();
				if (type.isAssignableFrom(Observable.class)) {
					return Observable.error(createException(inv));
				} else if (type.isAssignableFrom(Single.class)) {
					return Single.error(createException(inv));
				} else {
					return super.answer(inv);
				}
			}
		};
	}

	@NonNull
	private RuntimeException createException(
		InvocationOnMock invocation) {
		String s = invocation.toString();
		return new RuntimeException(
			"No mock defined for invocation " + s);
	}
}