package com.guavatest.basicUtilities;

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
}
