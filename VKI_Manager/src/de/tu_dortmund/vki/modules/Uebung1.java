package de.tu_dortmund.vki.modules;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class Uebung1 extends VkiModule {
	private String MODULE_NAME = "Übung 1";
	private String MODULE_VERSION = "1.0.1";
	private String MODULE_DATE = "9.9.2022";
	private String MODULE_LAST_EDIT_DATE = "9.9.2022";
	private String[] MODULE_AUTHORS = { "Robin Stecher" };
	private URLSource[] MODULE_SOURCES = { new URLSource("Own Know How") };

	// YOUR ATTRIBUTES

	// feel free, to add some attributes here :)

	// YOUR METHODS

	@Override
	public void runModule() {
		// This method is like the main method in java for you

		int[] arr = { 0, 4, -1, 37, 48, 785, 5 };

		// Aufgabe 2
		System.out.println("Max: " + findMax(arr));

		// Aufgabe 3
		System.out.println("Fünf teilbar: " + fuenfteilbar(arr));

		// Aufgabe 4
		System.out.println("Nicht invertiert: " + Arrays.toString(arr));
		System.out.println("Invertiert: " + Arrays.toString(inverse(arr)));

		// Aufgabe 5
		System.out.println("Gibt es Zahlen mehrfach: " + mehrfach(arr));
		// Geschätzter Zeitaufwand: O(n)

		// Aufgabe 7
		System.out.println("Summe der Menge: " + summiere(5));
		// Aufgabe 7b
		System.out.println("Summe der Menge: " + rekSummmeBis(5));

		// Aufgabe 8
		System.out.println("Größter gemeinsamer Teiler: " + ggt(5, 10));
	}

	public static int findMax(int[] menge) {
		int max = menge[0];

		for (int i = 0; i < menge.length; i++) {
			if (menge[i] > max) {
				max = menge[i];
			}
		}

		return max;
	}

	public static boolean fuenfteilbar(int[] menge) {
		boolean isDividable = false;

		for (int i = 0; i < menge.length; i++) {
			if (menge[i] % 5 == 0) {
				isDividable = true;
			}
		}

		return isDividable;
	}

	public static int[] inverse(int[] arr) {
		int[] inversed = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inversed[i] = arr[arr.length - i - 1];
		}

		return inversed;
	}

	public static boolean mehrfach(int[] arr) {
		boolean isMore = false;
		Set<Integer> karte = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (karte.contains(arr[i])) {
				isMore = true;
			} else {
				karte.add(arr[i]);
			}
		}

		return isMore;
	}

	public static int summiere(int limit) {
		int summe = 0;
		for (int i = 1; i <= limit; i++) {
			summe += i;
		}

		return summe;
	}

	public static int rekSummmeBis(int n) {
		if (n >= 1) {
			return rekSummmeBis(n - 1) + n;
		}

		return 0;
	}

	public static int ggt(int a, int b) {
		// Größter gemeinsamer Teiler

		if (b == 1 || a == 1) {
			return 1;
		} else if (a == b) {
			return a;
		}

		if (a > b) {
			return ggt(a - b, b);
		} else {
			return ggt(a, b - a);
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
