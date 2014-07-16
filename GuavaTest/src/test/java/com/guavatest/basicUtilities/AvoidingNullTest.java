package com.guavatest.basicUtilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	@Test
	public void orPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Assert.assertEquals(new Integer(5), possible.or(7));
	}
	
	@Test
	public void orAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Assert.assertEquals(new Integer(7), possible.or(7));
	}
	
	@Test
	public void orOptionalPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Optional<Integer> defaultOptional = Optional.of(7);
		Assert.assertEquals(possible, possible.or(defaultOptional));
	}
	
	@Test
	public void orOptionnalAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Optional<Integer> defaultOptional = Optional.of(7);
		Assert.assertEquals(defaultOptional, possible.or(defaultOptional));
	}
	
	@Test
	public void orNullPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Assert.assertEquals(new Integer(5), possible.orNull());
	}
	
	@Test
	public void orNullAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Assert.assertNull(possible.orNull());
	}	
	
	@Test
	public void asSetAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Set<Integer> set = possible.asSet();
		Assert.assertTrue(set.isEmpty());
	}
	
	@Test
	public void asSetPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Set<Integer> set = possible.asSet();
		Assert.assertEquals(1, set.size());
		Assert.assertEquals(new Integer(5), set.iterator().next());
	}
	
	@Test
	public void equalsTest() {
		Assert.assertTrue(Optional.of(5).equals(Optional.of(5)));
	}
	
	@Test
	public void notEqualsTest() {
		Assert.assertFalse(Optional.of(5).equals(Optional.of(4)));
	}
	
	@Test
	public void equalsAbsentTest() {
		Assert.assertTrue(Optional.absent().equals(Optional.absent()));
	}
	
	@Test
	public void notEqualsAbsentTest() {
		Assert.assertFalse(Optional.absent().equals(Optional.of(5)));
	}
	
	@Test
	public void presentInstancesTest() {
		List<Optional<Integer>> listValues = new ArrayList<Optional<Integer>>();
		listValues.add(Optional.of(5));
		Optional<Integer> absent = Optional.absent();
		listValues.add(absent);
		listValues.add(Optional.of(7));
		
		Iterator<Integer> iterPresents = Optional.presentInstances(listValues).iterator();
		Assert.assertEquals(new Integer(5), iterPresents.next());
		Assert.assertEquals(new Integer(7), iterPresents.next());
	}
}
