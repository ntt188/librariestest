package fr.tungnguyen.mokito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class TestList {
	
	private List<Integer> listeInt;
	
	@Before
	public void setUp() {
		listeInt = mock(List.class);
	}
	
	@Test
	public void testVerify() throws Exception {		
		listeInt.add(0);
		listeInt.add(2);
		listeInt.add(2);
		listeInt.clear();
		
		verify(listeInt).add(0);
		verify(listeInt).clear();
		
		verify(listeInt, times(2)).add(2);
		verify(listeInt, never()).add(1);
		verify(listeInt, times(3)).add(anyInt());
	}
	
	@Test
	public void testStubbing() throws Exception {
		when(listeInt.get(0)).thenReturn(1);
		when(listeInt.get(1)).thenReturn(2);
		
		assertEquals(1, listeInt.get(0).intValue());
		assertEquals(2, listeInt.get(1).intValue());
	}
	
	@Test
	public void testArgs() throws Exception {
		listeInt.add(0, 1);
		listeInt.add(1, 2);
		
		verify(listeInt).add(anyInt(), eq(1));
		verify(listeInt).add(anyInt(), eq(2));
		verify(listeInt,times(2)).add(anyInt(), anyInt());
		
		verify(listeInt, never()).add(eq(0), eq(2));
		verify(listeInt, never()).add(eq(1), eq(1));
		
		verify(listeInt).add(eq(0), anyInt());
		verify(listeInt).add(eq(1), anyInt());
	}
	
	@Test
	public void testInOrder() throws Exception {
		listeInt.add(0);		
		listeInt.add(2);
		listeInt.add(1);
		
		InOrder inOrder = inOrder(listeInt);
		
		inOrder.verify(listeInt).add(0);
		inOrder.verify(listeInt).add(2);
		inOrder.verify(listeInt).add(1);
	}

}
