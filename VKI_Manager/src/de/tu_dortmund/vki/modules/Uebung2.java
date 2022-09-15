package de.tu_dortmund.vki.modules;

import java.util.LinkedList;
import java.util.List;

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
		testPrintSqaure();
		
		System.out.println("Task 2: \n");
		testPower();
		
		System.out.println("Task 3: \n");
		testPowerRek();
	}
	
	// --- Test methods ---
	
	public void testPrintSqaure() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Square in length of " + i + "\n");
			printSquare(i);
			System.out.println("\n");
		}
	}
	
	public void testPower() {
		System.out.println("Results of power method: ");
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				System.out.println("x: " + i + " y: " + j + " Result: " + power(i, j));
			}
		}
	}
	
	public void testPowerRek() {
		System.out.println("Results of powerRek method: ");
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				System.out.println("x: " + i + " y: " + j + " Result: " + powerRek(i, j));
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
