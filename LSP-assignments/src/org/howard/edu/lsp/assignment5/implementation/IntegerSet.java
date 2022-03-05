package org.howard.edu.lsp.assignment5.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * this class IntegerSet has an ArrayList attribute called "set" that can be manipulated in various ways using class methods
 * @author Rachel
 *
 */
public class IntegerSet {
	
	
	private ArrayList<Integer> set = new ArrayList<Integer>();
	
	/**
	 * this is the default constructor for IntegerSet. It does nothing.
	 */
	public IntegerSet() {
		
	};
	
	/**
	 * this is the second constructor for IntegerSet. It allows the user to enter a list of numbers as the parameter and add them all to the set at once.
	 * instead of manually entering the elements of the IntegerSet, this method can be used.
	 * @param list
	 */
	public IntegerSet(Integer[] list) {
		set.addAll(Arrays.asList(list));
	};

	/**
	 * 
	 * this method clears all of the items out of the integer set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 * this method finds the size of the set and returns the value as the IntegerSet's length
	 * @return length
	 */
	public int length() {
		int length = set.size();
		return length;
	};
	
	/**
	 * this method determines whether this IntegerSet and IntegerSet b are equal to each other
	 * it returns true if the two IntegerSets are equal, and false otherwise
	 * @param b
	 * @return
	 */
	public boolean equals(IntegerSet b) {
		if (set.size() != b.set.size()) {
			return false;
		}
		else {
			ArrayList<Integer> sortedSetA = new ArrayList<Integer>(set);
			ArrayList<Integer> sortedSetB = new ArrayList<Integer>(b.set);
			Collections.sort(sortedSetA);
			Collections.sort(sortedSetB);
			
			for (Integer i = 0; i < set.size(); i++) {
				if (sortedSetA.get(i) != sortedSetB.get(i)) {
					return false;
				}
			}
		}
		return true;
	};
	
	/**
	 * this method determines whether or not this IntegerSet contains an int value. the method returns a boolean based on this result
	 * if the IntegerSet contains the int, then the method returns true. it returns false otherwise.
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) == value) {
				return true;
			}
		}
		return false;
	};
	
	/**
	 * this method finds the largest number in an IntegerSet. If the IntegerSet is empty, the method throws an IntegerSetException
	 * Otherwise, the method returns the largest number
	 * @return largestNum
	 * @throws IntegerSetException
	 */
	public int largest() throws IntegerSetException{
		if (set.isEmpty()) {
			throw new IntegerSetException("set contains no elements");
		}
		else {
			ArrayList<Integer> sortedSet = new ArrayList<Integer>(set);
			Integer index = set.size() - 1;
			int largestNum = sortedSet.get(index);
			return largestNum;
		}
	};
	
	/**
	 * this method finds the smallest number in an IntegerSet. If the IntegerSet is empty, the method throws an IntegerSetException
	 * Otherwise, the method returns the smallest number
	 * @return smallestNum
	 * @throws IntegerSetException
	 */
	public int smallest() throws IntegerSetException{
		if (set.isEmpty()) {
			throw new IntegerSetException("set contains no elements");
		}
		else {
			ArrayList<Integer> sortedSet = new ArrayList<Integer>(set);
			int smallestNum = sortedSet.get(0);
			return smallestNum;
		}
	};
	
	/**
	 * this method adds an item to the IntegerSet.
	 * this method does not return a value. It directly modifies the "set" variable.
	 * @param item
	 */
	public void add(int item) {
		if (set.contains(item)) {
			return;
		}
		else {
			set.add(item);
		}
	};

	/**
	 * this method removes an item from the IntegerSet.
	 * this method does not return a value. It directly modifies the "set" variable.
	 * @param item
	 */
	public void remove(int item) {
		if (set.contains(item)) {
			set.remove(set.indexOf(item));
		}
		else {
			return;
		}
	};
	
	/**
	 * this method finds the union between two IntegerSets
	 * the "set" variable is set equal to the value of the union 
	 * @param IntSetb
	 */
	public void union(IntegerSet IntSetb) {
		for (int i = 0; i < IntSetb.length(); i++) {
			if (set.contains(IntSetb.set.get(i))) {
				continue;
			}
			else {
				set.add(IntSetb.set.get(i));
			}
		} 
	};
	
	/** this method finds the intersection between two IntegerSets
	 * the "set" variable is set equal to the value of the intersection
	 * @param IntSetb
	 */
	public void intersect(IntegerSet IntSetb) {
		for (int i = 0; i < set.size(); i++) {
			if (IntSetb.contains(set.get(i))) {
				continue;
			}
			else {
				set.remove(set.get(i));
			}
		} 
	};
	
	public void diff(IntegerSet IntSetb) {
		this.union(IntSetb);
		ArrayList<Integer> union = new ArrayList<Integer>(this.set);
		this.intersect(IntSetb);
		ArrayList<Integer> intersection = new ArrayList<Integer>(this.set);
		for (int i = 0; i < union.size(); i++) {
			if (intersection.contains(union.get(i))) {
				union.remove(i);
			}
		this.set = union;
		
	}};
	
	/** 
	 * this method determines whether or not the IntegerSet is empty. 
	 * If the size of "set" is equal to zero, the method returns true. Otherwise it returns false
	 * @return
	 */
	public boolean isEmpty() {
		if (set.size() == 0) {
			return true;
		}
		return false;
	};

	/**
	 * this method converts the items in an IntegerSet into a string.
	 * the method also adds commas and spaces to make the set more legible
	 */
	public String toString() {
		String stringSet = new String();
		for (Integer i: this.set) {
			stringSet += i.toString();
			stringSet += ", ";
		}
		stringSet = stringSet.substring(0, stringSet.length() - 2);
		return stringSet;
	};

}
