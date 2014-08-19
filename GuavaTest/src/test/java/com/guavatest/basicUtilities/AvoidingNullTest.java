package com.guavatest.basicUtilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		assertTrue(possible.isPresent());
	}	
	
	@Test
	public void absentTest() {
		Optional<Integer> absent = Optional.absent();
		assertFalse(absent.isPresent());
	}
	
	@Test
	public void fromNullablePresentTest() {
		Integer intValue = new Integer(5);
		Optional<Integer> present = Optional.fromNullable(intValue);
		assertTrue(present.isPresent());
	}
	
	@Test
	public void fromNullableAbsentTest() {
		Integer intValue = null;
		Optional<Integer> present = Optional.fromNullable(intValue);
		assertFalse(present.isPresent());
	}
	
	@Test
	public void getTest() {
		Optional<Integer> possible = Optional.of(5);
		assertEquals(new Integer(5), possible.get());
	}
	
	@Test
	public void orPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		assertEquals(new Integer(5), possible.or(7));
	}
	
	@Test
	public void orAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		assertEquals(new Integer(7), possible.or(7));
	}
	
	@Test
	public void orOptionalPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Optional<Integer> defaultOptional = Optional.of(7);
		assertEquals(possible, possible.or(defaultOptional));
	}
	
	@Test
	public void orOptionnalAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Optional<Integer> defaultOptional = Optional.of(7);
		assertEquals(defaultOptional, possible.or(defaultOptional));
	}
	
	@Test
	public void orNullPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		assertEquals(new Integer(5), possible.orNull());
	}
	
	@Test
	public void orNullAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		assertNull(possible.orNull());
	}	
	
	@Test
	public void asSetAbsentTest() {
		Optional<Integer> possible = Optional.absent();
		Set<Integer> set = possible.asSet();
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void asSetPresentTest() {
		Optional<Integer> possible = Optional.of(5);
		Set<Integer> set = possible.asSet();
		assertEquals(1, set.size());
		assertEquals(new Integer(5), set.iterator().next());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(Optional.of(5).equals(Optional.of(5)));
	}
	
	@Test
	public void notEqualsTest() {
		assertFalse(Optional.of(5).equals(Optional.of(4)));
	}
	
	@Test
	public void equalsAbsentTest() {
		assertTrue(Optional.absent().equals(Optional.absent()));
	}
	
	@Test
	public void notEqualsAbsentTest() {
		assertFalse(Optional.absent().equals(Optional.of(5)));
	}
	
	@Test
	public void presentInstancesTest() {
		List<Optional<Integer>> listValues = new ArrayList<Optional<Integer>>();
		listValues.add(Optional.of(5));
		Optional<Integer> absent = Optional.absent();
		listValues.add(absent);
		listValues.add(Optional.of(7));
		
		Iterator<Integer> iterPresents = Optional.presentInstances(listValues).iterator();
		assertEquals(new Integer(5), iterPresents.next());
		assertEquals(new Integer(7), iterPresents.next());
	}
}
