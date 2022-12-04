package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

import java.util.ArrayList;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_07 extends VkiModule {
    private String MODULE_NAME = "Übung 7 DAP 1";
    private String MODULE_VERSION = "1.0.0";
    private String MODULE_DATE = "2.12.2022";
    private String MODULE_LAST_EDIT_DATE = "2.12.2022";
    private String[] MODULE_AUTHORS = {"Robin Stecher"};
    private URLSource[] MODULE_SOURCES = {};

    // YOUR ATTRIBUTES

    // feel free, to add some attributes here :)



    // YOUR METHODS

    @Override
    public void runModule() {
        // This method is like the main method in java for you


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
