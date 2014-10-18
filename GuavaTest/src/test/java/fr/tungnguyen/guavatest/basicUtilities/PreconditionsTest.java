package fr.tungnguyen.guavatest.basicUtilities;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class PreconditionsTest {
		
	@Test
	public void testCheckArgumentTrue() throws Exception {
		Preconditions.checkArgument(true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckArgumentFalse() throws Exception {
		Preconditions.checkArgument(false);
	}
	
	@Test
	public void testCheckArgumentWithMessageTrue() throws Exception {
		Preconditions.checkArgument(true, "Message");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckArgumentWithMessageFalse() throws Exception {
		Preconditions.checkArgument(false, "Message");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNullNull() throws Exception {
		Preconditions.checkNotNull(null);
	}
	
	@Test
	public void testCheckNotNullOk() throws Exception {
		Preconditions.checkNotNull("");
	}
}
