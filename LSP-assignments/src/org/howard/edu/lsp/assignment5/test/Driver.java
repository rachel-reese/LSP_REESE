package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

public class Driver { 
	
	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		System.out.println("the values 1, 2, 3, and 4 have been added to set 1 using the add method");
		System.out.println("value of set 1 (expected 1, 2, 3, 4): " + set1.toString() + "\n");
		set1.remove(4);
		System.out.println("the value 4 has been removed from set 1 using the remove method");
		System.out.println("value of set 1 (expected: 1, 2, 3): " + set1.toString() + "\n");
		System.out.println("length of set 1 (expected: 3): " + set1.length() + "\n");
		System.out.println("largest value in set 1 (expected: 3): " + set1.largest());
		System.out.println("smallest value in set 1 (expected: 1): " + set1.smallest() + "\n");
		System.out.println("set 1 contains 3 (expected: true): " + set1.contains(3));
		System.out.println("set 1 contains 5 (expected: false): " + set1.contains(5) + "\n");
		System.out.println("set 1 is empty (expected: false): " + set1.isEmpty());
		set1.clear();
		System.out.println("set 1 has been cleared using the clear method and now contains no items");
		System.out.println("set 1 is empty (expected: true): " + set1.isEmpty() + "\n");
		
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		Integer[] list2 = {25, 40, 35};
		IntegerSet setB = new IntegerSet(list2);
		Integer[] list3 = {25, 40, 35};
		IntegerSet setC = new IntegerSet(list3);
		Integer[] list4 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setD = new IntegerSet(list4);
		Integer[] list5 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setE = new IntegerSet(list5);
		Integer[] list6 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setF = new IntegerSet(list6);
		
		System.out.println("sets A-F have been created using the IntegerSet constructor to add multiple values at once\n");
		System.out.println("value of set A (expected: 10, 15, 20, 25, 30, 35, 40): "+ "\n" + setA.toString());
		System.out.println("value of set B (expected: 25, 40, 35): " + "\n" + setB.toString());
		System.out.println("value of set C (expected: 25, 40, 35): " + "\n" + setC.toString() + "\n");
		System.out.println("set B is equal to set C (expected output is true): " + setB.equals(setC));
		System.out.println("set B is equal to set A (expected output is false): " + setB.equals(setA) + "\n");
		
		System.out.println("expected output for D, E, and F is 11, 15, 21, 25, 31, 35, 41");
		System.out.println("value of set D: " + setD.toString());
		System.out.println("value of set E: " + setE.toString());
		System.out.println("value of set F: " + setF.toString() + "\n");
		setD.union(setA);
		System.out.println("union of set A and set D (expected: 11, 15, 21, 25, 31, 35, 41, 10, 20, 30, 40): "+ "\n" + setD);
		setE.intersect(setA);
		System.out.println("intersection of set A and set E (expected: 15, 25, 35): "+ "\n" + setE);
		setF.diff(setA);
		System.out.println("difference of set A and set F (expected: 11, 21, 31, 41, 10, 20, 30, 40): "+ "\n" + setF);
		
	}

}
