package de.tu_dortmund.vki.modules;


import java.util.Arrays;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class Uebung2 extends VkiModule {
	private String MODULE_NAME = "Übung 2";
	private String MODULE_VERSION = "1.0.0";
	private String MODULE_DATE = "15.09.2022";
	private String MODULE_LAST_EDIT_DATE = "15.09.2022";
	private String[] MODULE_AUTHORS = {"Robin Stecher"};
	private URLSource[] MODULE_SOURCES = {};
	
	// YOUR ATTRIBUTES
	
	// feel free, to add some attributes here :)
	
	

	// YOUR METHODS
	
	@Override
	public void runModule() {
		// This method is like the main method in java for you
		
		System.out.println("Task 1: \n");
		testPrintSquare();
		
		System.out.println("Task 2: \n");
		testPower();
		
		System.out.println("Task 3: \n");
		testPowerRek();
		
		System.out.println("Task 4: \n");
		testArithmetik();
		
		System.out.println("\n\nTask 5: \n");
		testLog2();
		
		System.out.println("\n\nTask 6: \n");
		testFakultaet();
		testNUeberK();
		
		System.out.println("\n\nTask 7: \n");
		testMax();
		
		System.out.println("\n\nTask 8: \n");
		testPrimes();
	}
	
	// --- Test methods ---
	
	public void testPrintSquare() {
		// Task 1
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("Square in length of " + i + "\n");
			printSquare(i);
			System.out.println("\n");
		}
	}
	
	public void testPower() {
		// Task 2
		
		System.out.println("Results of power method: ");
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				System.out.println("x: " + i + " y: " + j + " Result: " + power(i, j));
			}
		}
	}
	
	public void testPowerRek() {
		// Task 3
		
		System.out.println("Results of powerRek method: ");
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				System.out.println("x: " + i + " y: " + j + " Result: " + powerRek(i, j));
			}
		}
	}
	
	public void testArithmetik() {
		// Task 4
		
		System.out.println("Arithmetiktest: ");
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				System.out.println("Addition x: " + i + " y: " + j + " Result: " + Arithmetik.addition(i, j));
				System.out.println("Subtraktion x: " + i + " y: " + j + " Result: " + Arithmetik.subtraktion(i, j));
			}
		}
	}
	
	public void testLog2() {
		// Task 5
		
		int logNum = 64;
		System.out.println("Log2(" + logNum + ") = " + log2(logNum));
	}
	
	public void testFakultaet() {
		// Task 6
		
		int fak = 2;
		System.out.println("Fakultät von " + fak + " ist " + fakultaet(fak));
	}
	
	public void testNUeberK() {
		// Task 6
		
		int[][] values = {{12, 6}, {11, 5}, {11, 6}}; 
		
		for (int[] current : values) {
			System.out.println(current[0] + " über " + current[1] + " ist " + nUeberK(current[0], current[1]));
		}
	}
	
	public void testMax() {
		// Task 7
		
		int[] arr = {-1, -423, 5, 6, 7, 4, 9};
		System.out.println("Maximum von der Menge " + Arrays.toString(arr) + " ist: " + max(arr));
	}
	
	public void testPrimes() {
		// Task 8
		
		boolean[] primes = computePrimes(1000);
		for(int i = 0; i < primes.length; i++) {
			if(primes[i] == true) {
				System.out.println(i + " ist eine Primzahl");
			}
		}
	}
	
	
	
	// --- Task methods ---
	
	
	public void printSquare(int length) {
		// Task method for task 1
		
		for(int i = 0; i < length; i++) {
			// Lines
			if(i == 0 || i == length - 1) {
				for(int j = 0; j < length; j++) {
					// Full Rows
					System.out.print('*');
				}
			} else {
				for(int j = 0; j < length; j++) {
					if(j == 0 || j == length - 1) {
						System.out.print('*');
					} else {
						System.out.print(' ');
					}
				}
			}
			System.out.print('\n');
		}
	}
	
	
	public float power(int x, int y) {
		float result = x;
		
		if(y < 0) {
			float denominator = x;
			for(int i = 0; i < Math.abs(y) - 1; i++) {
				denominator *= x;
			}
			result = 1 / denominator;
		} else if(y == 0) {
			result = 1;
		} else {
			for(int i = 0; i < y - 1; i++) {
				result *= x;
			}
		}
		
		return result;
	}
	
	
	public float powerRek(int x, int y) {
		if(y == 0) {
			return 1;
		} else if(y < 0) {
			return 1 / powerRek(x, Math.abs(y));
		} else {
			return powerRek(x, y - 1) * x;
		}
	}
	
	public int log2(int x) {
		int num = x;
		int counter = 0;
		while(num >= 2) {
			num /= 2;
			counter++;
		}
		
		return counter;
	}
	
	public int fakultaet(int x) {
		if(x > 0) {
			return fakultaet(x - 1) * x;
		} else {
			return 1;
		}
	}
	
	public int nUeberK(int n, int k) {
		return fakultaet(n) / (fakultaet(k) * fakultaet(n - k));
	}
	
	public int max(int[] arr) {
		return maxHelp(arr, arr[0], 1);
	}
	
	public int maxHelp(int[] arr, int max, int index) {
		if(index == arr.length) {
			return max;
		} else if(arr[index] > max) {
			return maxHelp(arr, arr[index], index + 1);
		} else {
			return maxHelp(arr, max, index + 1);
		}
	}
	
	public boolean[] computePrimes(int amount) {
		boolean[] primes = new boolean[amount];
		
		for(int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		
		primes[0] = false;
		primes[1] = false; 
		
		for(int i = 0; i < primes.length; i++) {
			if(primes[i] == true) {
				int y = 2;
				while(y * i < amount) {
					primes[y * i] = false;
					y++;
				}
			}
		}
		
		return primes;
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



class Arithmetik {
	public static int addition(int x, int y) {
		int a = x;
		int b = y;
		
		if(y == 0) {
			return x;
		} else if(y < 0) {
			a--;
			b++;
			return addition(a, b);
		} else {
			a++;
			b--;
			return addition(a, b);
		}
	}
	
	public static int subtraktion(int x, int y) {
		int a = x;
		int b = y;
		
		if(y == 0) {
			return x;
		} else if(y < 0) {
			a++;
			b++;
			return subtraktion(a, b);
		} else {
			a--;
			b--;
			return subtraktion(a, b);
		}
	}
}
