package org.howard.edu.lsp.assignment6.juint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.howard.edu.lsp.assignment6.integerset.IntegerSetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	
	@Test
	@DisplayName("IntegerSet.clear test cases")
	public void testClear() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertNotEquals(true, set1.isEmpty());
		set1.clear();
		assertEquals(true, set1.isEmpty());	
	}

	@Test
	@DisplayName("IntegerSet.length test cases")
	public void testLength() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertEquals(5, set1.length());
		set1.remove(5);
		assertNotEquals(5, set1.length());
	}
	
	@Test
	@DisplayName("IntegerSet.equals test cases")
	public void testEquals() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		IntegerSet set2 = new IntegerSet(list);
		assertTrue(set1.equals(set2));
		set2.add(7);
		assertFalse(set1.equals(set2));
	}
	
	@Test
	@DisplayName("IntegerSet.contains test cases")
	public void testContains() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertTrue(set1.contains(2));
		set1.remove(2);
		assertFalse(set1.contains(2));
		assertFalse(set1.contains(7));
		set1.add(7);
		assertTrue(set1.contains(7));
	}
	
	@Test
	@DisplayName("IntegerSet.largest test cases")
	public void testLargest() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertEquals(5, set1.largest());
		set1.remove(5);
		assertNotEquals(5, set1.largest());
		assertEquals(4, set1.largest());
	}
	
	@Test
	@DisplayName("IntegerSet.largest exception test cases")
	public void testLargest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.largest();
		});
		
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@Test
	@DisplayName("IntegerSet.smallest test cases")
	public void testSmallest() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertEquals(1, set1.smallest());
		set1.remove(1);
		assertNotEquals(1, set1.smallest());
		assertEquals(2, set1.smallest());
	}
	
	@Test
	@DisplayName("IntegerSet.smallest exception test cases")
	public void testSmallest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.smallest();
		});
		
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("IntegerSet.add test cases")
	public void testAdd() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		set1.add(7);
		assertEquals("1, 2, 3, 4, 5, 7", set1.toString());
		assertNotEquals("1, 2, 3, 4, 5", set1.toString());
		set1.add(5);
		assertEquals("1, 2, 3, 4, 5, 7", set1.toString());
		assertNotEquals("1, 2, 3, 4, 5, 7, 5", set1.toString());
	}
	
	@Test
	@DisplayName("IntegerSet.remove test cases")
	public void testRemove() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		set1.remove(5);
		assertEquals("1, 2, 3, 4", set1.toString());
		assertNotEquals("1, 2, 3, 4, 5", set1.toString());
	}
	
	@Test
	@DisplayName("IntegerSet.remove exception test cases")
	public void testRemove_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.remove(7);
		});
		
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("IntegerSet.union test cases")
	public void testUnion() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		Integer[] list4 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setD = new IntegerSet(list4);
		setD.union(setA);
		assertEquals("11, 15, 21, 25, 31, 35, 41, 10, 20, 30, 40", setD.toString());
		assertNotEquals("11, 15, 15, 21, 25, 25, 31, 35, 35, 41, 10, 20, 30, 40", setD.toString());
	}
	
	@Test
	@DisplayName("IntegerSet.union exception test cases")
	public void testUnion_THROWS_EXCEPTION() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		IntegerSet setD = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			setD.union(setA);
		});
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("IntegerSet.intersect test cases")
	public void testIntersect() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		Integer[] list4 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setD = new IntegerSet(list4);
		setD.intersect(setA);
		assertEquals("15, 25, 35", setD.toString());
		assertNotEquals("11, 15, 21, 25, 31, 35, 41", setD.toString());

	}
	
	@Test
	@DisplayName("IntegerSet.intersect exception test cases")
	public void testIntersect_THROWS_EXCEPTION() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		IntegerSet setD = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			setD.intersect(setA);
		});
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("IntegerSet.difference test cases")
	public void testDifference() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		Integer[] list4 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setD = new IntegerSet(list4);
		setD.diff(setA);
		assertEquals("11, 21, 31, 41, 10, 20, 30, 40", setD.toString());
		assertNotEquals("11, 21, 31, 41, 30, 40", setD.toString());
		
	}
	
	@Test
	@DisplayName("IntegerSet.diff exception test cases")
	public void testDiff_THROWS_EXCEPTION() {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		IntegerSet setD = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			setD.diff(setA);
		});
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("IntegerSet.isEmpty test cases")
	public void testIsEmpty() {
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.isEmpty());
		set1.add(7);
		assertFalse(set1.isEmpty());
	}
	
	@Test
	@DisplayName("IntegerSet.toString test cases")
	public void testToString() {
		Integer[] list = {1, 2, 3, 4, 5};
		IntegerSet set1 = new IntegerSet(list);
		assertEquals("1, 2, 3, 4, 5", set1.toString());
		set1.remove(3);
		assertNotEquals("1, 2, 3, 4, 5", set1.toString());
		assertEquals("1, 2, 4, 5", set1.toString());
	}
	
	@Test
	@DisplayName("IntegerSet.toString exception test cases")
	public void testToString_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.toString();
		});
		String expectedMessage = "set contains no elements";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
	}
}
