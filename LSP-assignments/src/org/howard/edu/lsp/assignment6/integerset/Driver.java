package org.howard.edu.lsp.assignment6.integerset;

public class Driver { 
	
	public static void main(String[] args) throws IntegerSetException {
		Integer[] list = {10, 15, 20, 25, 30, 35, 40};
		IntegerSet setA = new IntegerSet(list);
		Integer[] list6 = {11, 15, 21, 25, 31, 35, 41};
		IntegerSet setF = new IntegerSet(list6);
		setF.diff(setA);
		System.out.println("difference of set A and set F (expected: 11, 21, 31, 41, 10, 20, 30, 40): "+ "\n" + setF.toString());
	}
	
}