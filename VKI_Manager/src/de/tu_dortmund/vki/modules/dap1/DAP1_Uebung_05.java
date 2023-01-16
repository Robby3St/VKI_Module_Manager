package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

import java.util.ArrayList;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_05 extends VkiModule {
    private String MODULE_NAME = "Übung 5 DAP 1";
    private String MODULE_VERSION = "1.0.0";
    private String MODULE_DATE = "25.11.2022";
    private String MODULE_LAST_EDIT_DATE = "23.12.2022";
    private String[] MODULE_AUTHORS = {"Robin Stecher"};
    private URLSource[] MODULE_SOURCES = {};

    // YOUR ATTRIBUTES

    // feel free, to add some attributes here :)



    // YOUR METHODS

    @Override
    public void runModule() {
        // This method is like the main method in java for you

        System.out.println(addCalcExists(new int[] {5, 3, 2, 4, 1, 0, 3}, 0, 0)); // Should be true
        System.out.println(addCalcExists(new int[] {5, 3, 2, 4, 1, 0, 3, 5}, 0, 0)); // Should be false
        System.out.println(addCalcExists(new int[] {5, 5, 5}, 0, 0)); // Should be false

        System.out.println(addCalcExistsExp(new int[] {5, 3, 2, 4, 1, 0, 3}, 0, 0,
                "")); // Should be true
        System.out.println(addCalcExistsExp(new int[] {5, 3, 2, 4, 1, 0, 3, 5}, 0, 0,
                "")); // Should be false
        System.out.println(addCalcExistsExp(new int[] {5, 5, 5}, 0, 0, "")); // Should be false
    }

    public boolean addCalcExists(int[] values, int position, int result) {
        if(values.length == position) {
            return result == 0;
        }

        if(addCalcExists(values, position + 1, result + values[position]))
            return true;
        return addCalcExists(values, position + 1, result - values[position]);
    }

    public String addCalcExistsExp(int[] values, int position, int result, String exp) {
        if(values.length == position) {
            if(result == 0) {
                return exp;
            } else {
                return "Calc not possible.";
            }
        }

        String calc = addCalcExistsExp(values, position + 1,
                result + values[position], exp + "+" + values[position]);

        if(!calc.equals("Calc not possible.")) {
            return calc;
        }
        return addCalcExistsExp(values, position + 1,
                result - values[position], exp + "-" + values[position]);
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
