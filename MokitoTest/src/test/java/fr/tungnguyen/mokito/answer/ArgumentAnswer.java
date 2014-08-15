package fr.tungnguyen.mokito.answer;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ArgumentAnswer<T> implements Answer<T> {

	private T answer;
	private Object[] args;
	
	public ArgumentAnswer(T answer) {
		this.answer = answer;
	}
	
	@Override
	public T answer(InvocationOnMock invocation) throws Throwable {
		this.args = invocation.getArguments();
		return this.answer;
	}

	public Object[] getArgs() {
		return args;
	}
}
