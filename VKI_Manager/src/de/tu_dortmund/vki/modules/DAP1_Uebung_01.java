package de.tu_dortmund.vki.modules;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_01 extends VkiModule {
	private String MODULE_NAME = "DAP1 Übung Blatt 1";
	private String MODULE_VERSION = "1.0.0";
	private String MODULE_DATE = "16.10.2022";
	private String MODULE_LAST_EDIT_DATE = "16.10.2022";
	private String[] MODULE_AUTHORS = {"Robin Stecher"};
	private URLSource[] MODULE_SOURCES = {};
	
	// YOUR ATTRIBUTES
	
	// feel free, to add some attributes here :)
	
	

	// YOUR METHODS
	
	@Override
	public void runModule() {
		// This method is like the main method in java for you
		
		testRemainder();
		testIsOdd();
		testIsEven();
		testToEven();
		testIsDivisible();
	}
	
	// TEST METHODS
	
	public void testRemainder() {
		int dividend = 10;
		int divisor = 3;
		System.out.println("Remainder of " + dividend + " % " + divisor + " is: " + remainder(dividend, divisor));
	}
	
	public void testIsOdd() {
		int odd = 6;
		int notOdd = 1337;
		System.out.println("\nIs odd --> 1, is not odd --> 0");
		System.out.println("Is odd (" + odd + "): " + isOdd(odd));
		System.out.println("Is not odd (" + notOdd + "): " + isOdd(notOdd));
	}
	
	public void testIsEven() {
		int even = 6;
		int notEven = 1337;
		System.out.println("\nIs even --> 1, is not even --> 0");
		System.out.println("Is even (" + even + "): " + isEven(even));
		System.out.println("Is not even (" + notEven + "): " + isEven(notEven));
	}
	
	public void testToEven() {
		int value = 13;
		int even = 26;
		System.out.println("\nValue " + value + " to even is: " + toEven(value));
		System.out.println("Even " + even + " to even is: " + toEven(even));
	}
	
	public void testIsDivisible() {
		int[] num1 = {10, 5, 10};
		int[] num2 = {10, 5, 6};
		
		System.out.println("\nDivisor " + num1[0] + " is divisible by " + num1[1] + " and " + num1[2] + "? --> " + isDivisible(num1[0], num1[1], num1[2]));
		System.out.println("Divisor " + num2[0] + " is divisible by " + num2[1] + " and " + num2[2] + "? --> " + isDivisible(num2[0], num2[1], num2[2]));
	}
	
	
	// CUSTOM METHODS
	
	public int remainderOld(int dividend, int divisor) {
		return dividend % divisor;
	}
	
	public boolean isOddOld(int value) {
		boolean result = value % 2 == 0 ? true : false;
		return result;
	}
	
	
	public int remainder(int dividend, int divisor) {
		// n - b * [n / b]
		return dividend - divisor * ( dividend / divisor );
	}
	
	public int isOdd(int value) {
		return remainder(value, 2);
//		return remainder(value, 2) == 0 ? 0 : 1;
	}
	
	public int isEven(int value) {
		return remainder(value + 1, 2);
	}
	
	public int toEven(int value) {
		return (value + 1) / 2 * 2;
	}
	
	public int isDivisible(int dividend, int divisor1, int divisor2) {
		return remainder(dividend, divisor1) + remainder(dividend, divisor2);
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
