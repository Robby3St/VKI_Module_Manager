package de.tu_dortmund.vki.modules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_02 extends VkiModule {
	private String MODULE_NAME = "DAP1 Übung 2";
	private String MODULE_VERSION = "1.0.0";
	private String MODULE_DATE = "27.10.2022";
	private String MODULE_LAST_EDIT_DATE = "27.10.20222";
	private String[] MODULE_AUTHORS = {"Robin Stecher"};
	private URLSource[] MODULE_SOURCES = {};
	
	// YOUR ATTRIBUTES
	
	// feel free, to add some attributes here :)
	
	

	// YOUR METHODS
	
	@Override
	public void runModule() {
		// This method is like the main method in java for you
		
		testGreatestProperDivisor();
		testCountPairs();
		testWrittenBoth();
		testNotWrittenBoth();
		testCountWrittenBoth();
		testBiggerThan();
		testPrimeFactorization();
		testIsSquare();
		testExtractDiagonal();
	}
	
	public int greatestProperDivisor(int n) {
		int result = 1;
		for(int i = n - 1; i > 1; i--) {
			if(n % i == 0) {
				result = i;
				return result;
			}
		}
		
		return result;
	}
	
	public int countPairs(int[] arr) {
		boolean isPair = false;
		int numberOfPairs = 0;
		for(int i = 1; i < arr.length; i++) {
			if(!isPair && arr[i] == arr[i-1]) {
				numberOfPairs++;
				isPair = true;
			} else if(isPair) {
				isPair = false;
			}
		}
		
		return numberOfPairs;
	}
	
	public boolean writtenBoth(int[] exam1, int[] exam2) {
		HashSet<Integer> written1 = new HashSet<Integer>();
		boolean found = false;
		
		for (Integer i : exam1) {
			written1.add(i);
		}
		
		for (Integer i : exam2) {
			if(written1.contains(i)) {
				found = true;
			}
		}
		
		return found;
	}
	
	public boolean notWrittenBoth(int[] exam1, int[] exam2) {
		return !writtenBoth(exam1, exam2);
	}
	
	public int countWrittenBoth(int[] exam1, int[] exam2) {
		HashSet<Integer> written1 = new HashSet<Integer>();
		int found = 0;
		
		for (Integer i : exam1) {
			written1.add(i);
		}
		
		for (Integer i : exam2) {
			if(written1.contains(i)) {
				found++;
			}
		}
		
		return found;
	}
	
	public boolean biggerThan(int[] exam1, int[] exam2) {
		int min1 = exam1[0];
		int max2 = 0;
		
		for (int i : exam1) {
			if(i < min1) {
				min1 = i;
			}
		}
		
		for (int i : exam2) {
			if(i > max2) {
				max2 = i;
			}
		}
		
		return min1 > max2 ? true : false;
	}
	
	public int[] primeFactorization(int n) {
		int[] primes = new int[n + 1];
		
		for(int i = 0; i < primes.length; i++) {
			primes[i] = i;
		}
		
		primes[0] = 0;
		primes[1] = 0;
		
		for(int i = 3; i < primes.length; i++) {
			int x = 2;
			for(int y = i * x; y < primes.length; y *= x) {
				primes[y] = 0;
			}
		}
		
		int count = 0; // counts all 0s in primes to clear them out later
		
		for(int i = 0; i < primes.length; i++) {
			if(primes[i] == 0) {
				count++;
			}
		}
		
		// Transfer the primes array to the result array without any 0
		
		int[] result = new int[primes.length - count];
		int fillIndex = 0;
		for(int i = 0; i < primes.length; i++) {
			if(primes[i] != 0) {
				result[fillIndex] = primes[i];
				fillIndex++;
			}
		}
		
		return result;
	}
	
	public boolean isSquare(int[][] matrix) {
		int outerSize = 0;
		int innerSize = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			outerSize++;
			int currentInnerSize = 0;
			for(int j = 0; j < matrix[i].length; j++) {
				currentInnerSize++;
				if(currentInnerSize > innerSize) {
					innerSize = currentInnerSize;
				}
			}
		}
		
		return outerSize == innerSize ? true : false;
	}
	
	public void scalMult(int[][] matrix, int k) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] *= k;
			}
		}
	}
	
	public int[] extractDiagonal(int[][] matrix) {
		int[] diagonal = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			if(i < matrix[i].length) {
				diagonal[i] = matrix[i][i];
			}
		}
		
		return diagonal;
	}
	
	
	// TEST METHODS
	
	public void testGreatestProperDivisor() {
		int n = 30;
		System.out.println("Greatest proper divisor of " + n + " is: " + greatestProperDivisor(n));
	}
	
	public void testCountPairs() {
		int arr1[] = {1, 1, 3, 3, 1, 2, 2, 2, 1};
		int arr2[] = {1, 3, 3, 3, 3, 2, 2, 5, 5};
		
		System.out.println("Arr1 pairs: " + countPairs(arr1));
		System.out.println("Arr2 pairs: " + countPairs(arr2));
	}
	
	public void testWrittenBoth() {
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {7, 9, 16, 24, 19};
		
		int[] arr3 = {7, 9, 16, 24, 19, 2, 3847};
		
		System.out.println("Has anyone written both: " + writtenBoth(arr1, arr2));
		System.out.println("Has anyone written both (Stack 2): " + writtenBoth(arr1, arr3));
	}
	
	public void testNotWrittenBoth() {
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {7, 9, 16, 24, 19};
		
		int[] arr3 = {7, 9, 16, 24, 19, 2, 3847};
		
		System.out.println("Has no one written both: " + notWrittenBoth(arr1, arr2));
		System.out.println("Has no one written both (Stack 2): " + notWrittenBoth(arr1, arr3));
	}
	
	public void testCountWrittenBoth() {
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {7, 9, 16, 24, 19};
		
		int[] arr3 = {7, 9, 16, 24, 19, 2, 3847};
		int[] arr4 = {7, 9, 16, 24, 19, 2, 3847, 2, 5, 3, 1};
		
		System.out.println("How many have written both: " + countWrittenBoth(arr1, arr2));
		System.out.println("How many have written both:  (Stack 2): " + countWrittenBoth(arr1, arr3));
		System.out.println("How many have written both:  (Stack 3): " + countWrittenBoth(arr1, arr4));
	}
	
	public void testBiggerThan() {
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {7, 9, 16, 24, 19};
		
		int[] arr3 = {7, 9, 16, 24, 19, 2, 3847};
		int[] arr4 = {7, 9, 16, 24, 19, 2, 3847, 2, 5, 3, 1};
		
		System.out.println("Exam 1 has only bigger numbers than exam 2: " + biggerThan(arr2, arr1));
		System.out.println("Exam 1 has only bigger numbers than exam 2 (Stack 2): " + biggerThan(arr4, arr1));
	}
	
	public void testPrimeFactorization() {
		System.out.println("Primes: " + Arrays.toString(primeFactorization(30)));
	}
	
	public void testIsSquare() {
		int[][] matrix = {
				{1,2,3},
				{1,2,3},
				{1,2,3}
		};
		System.out.println("Is square: " + isSquare(matrix));
	}
	
	public void testExtractDiagonal() {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("Diagonal: " + Arrays.toString(extractDiagonal(matrix)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// General Module stuff (you can just ignore it)
	
	// -- Getters --
	
	public String getModuleName() {
		return MODULE_NAME;
	}
	public String getModuleVersion() {
		return MODULE_VERSION;
	}
	public String getModuleDate() {
		return MODULE_DATE;
	}
	public String getModuleLastEditDate() {
		return MODULE_LAST_EDIT_DATE;
	}
	public String[] getModuleAuthors() {
		return MODULE_AUTHORS;
	}
	public URLSource[] getModuleSources() {
		return MODULE_SOURCES;
	}

}
