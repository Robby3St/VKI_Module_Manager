package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.modules.dap1.utils.uebung03.*;
import de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus.MethodsWithArrays;
import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

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
    }

    public void testMethodWithArrays() {
        int[] arr = {1, 2, 3, 3, 3, 3, 2, 2, 2, 2, 6, 7, 4, 6, 2, 4};
        System.out.println("Most: " + MethodsWithArrays.most(arr));
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
