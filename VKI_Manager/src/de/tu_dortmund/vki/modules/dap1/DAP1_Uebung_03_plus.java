package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.modules.dap1.utils.uebung03.*;
import de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus.MethodsWithArrays;
import de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus.Numbers;
import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

import java.util.ArrayList;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_03_plus extends VkiModule {
    private String MODULE_NAME = "Übung 3+ DAP 1";
    private String MODULE_VERSION = "1.0.0";
    private String MODULE_DATE = "5.11.2022";
    private String MODULE_LAST_EDIT_DATE = "5.11.2022";
    private String[] MODULE_AUTHORS = {"Robin Stecher"};
    private URLSource[] MODULE_SOURCES = {};

    // YOUR ATTRIBUTES

    // feel free, to add some attributes here :)



    // YOUR METHODS

    @Override
    public void runModule() {
        // This method is like the main method in java for you

        testMethodWithArrays();
        System.out.println("\n");
        testNumbers();
        System.out.println("\n");
        testGenerate();
        System.out.println("\n");
        testPut();
    }

    public void testMethodWithArrays() {
        int[] arr = {1, 2, 3, 3, 3, 3, 2, 2, 2, 2, 6, 7, 4, 6, 2, 4};
        int[] numbers = {8, 84, 85, 37, 27, 45, 45, 7, 5};
        int[] zeroChains = {1, 5, 0, 2, 4, 0, 0, 3, 5, 4, 6, 7, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 5, 7, 0, 0, 0};
        System.out.println("Most: " + MethodsWithArrays.most(arr));
        System.out.println("Last hit: " + MethodsWithArrays.lastHit(arr, numbers));
        System.out.println("Zero Chain: " + MethodsWithArrays.zeroSequence(zeroChains));
    }

    public Numbers generate(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                list.add(arr[i]);
            }
        }
        if(list.size() > 0) {
            Numbers n = new Numbers(list.size());
            for(int i = 0; i < list.size(); i++) {
                n.insert(list.get(i));
            }

            return n;
        }
        return null;
    }

    private void testGenerate() {
        int[] test = {-2, -1, -56, -14};
        int[] test2 = {-2, 5, 5, -3, 5, -2, 6, 8, 3, 643, 0, 634, 3, -4};
        tryPrintGenerate(generate(test));
        tryPrintGenerate(generate(test2));
    }

    public boolean put(int[] arr, Numbers n) {
        for(int i = 0; i < arr.length; i++) {
            if(!n.insert(arr[i])) {
                return false;
            }
        }

        return  true;
    }

    public void testPut() {
        int[] arr = {1, 6};
        int[] arr2 = {2, 45, 3, 6, 5, 43, 356, 3};
        int[] numbers = {4, 5, 2, 6, 0, 4};
        Numbers n = new Numbers(numbers.length);
        for(int i = 0; i < numbers.length; i++) {
            n.insert(numbers[i]);
        }
        n.reset(2);
        System.out.println("Numbers object before insertion1: " + n.toString());
        System.out.println("Could insert all: " + put(arr, n));
        System.out.println("Numbers object after insertion1: " + n.toString());
        System.out.println("Could insert all: " + put(arr2, n));
        System.out.println("Numbers object after insertion2: " + n.toString());
    }

    public void tryPrintGenerate(Numbers n) {
        if(n != null) {
            System.out.println("Generate Test1: " + n.toString());
        } else {
            System.out.println("Generate Test1: null");
        }
    }

    public void testNumbers() {
        Numbers n = new Numbers(5);
        n.insert(1);
        n.insert(2);
        n.insert(3);
        n.reset(1);
        n.insert(4);
        n.insert(5);
        n.insert(6);
        Numbers copy = n.copy();
        System.out.println("Numbers 1: " + n.toString());
        System.out.println("Numbers 1 copy: " + copy.toString());
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
