package com.guavatest.basicUtilities;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Optional;

public class AvoidingNullTest {

	@Test(expected=NullPointerException.class)
	public void ofNullTest() {
		Optional.of(null);
	}
	
	@Test
	public void isPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Assert.assertTrue(possible.isPresent());
	}	
	
	@Test
	public void absentTest() {
		Optional<Integer> absent = Optional.absent();
		Assert.assertFalse(absent.isPresent());
	}
	
	@Test
	public void fromNullablePresentTest() {
		Integer intValue = new Integer(5);
		Optional<Integer> present = Optional.fromNullable(intValue);
		Assert.assertTrue(present.isPresent());
	}
	
	@Test
	public void fromNullableAbsentTest() {
		Integer intValue = null;
		Optional<Integer> present = Optional.fromNullable(intValue);
		Assert.assertFalse(present.isPresent());
	}
	
	@Test
	public void getTest() {
		Optional<Integer> possible = Optional.of(5);
		Assert.assertEquals(new Integer(5), possible.get());
	}
}
