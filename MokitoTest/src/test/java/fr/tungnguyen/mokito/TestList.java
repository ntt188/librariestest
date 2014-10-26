package fr.tungnguyen.mokito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
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
}
