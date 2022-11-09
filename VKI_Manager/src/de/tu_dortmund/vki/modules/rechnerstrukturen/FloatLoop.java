package de.tu_dortmund.vki.modules.rechnerstrukturen;

import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class FloatLoop extends VkiModule {
    private String MODULE_NAME = "Demo Module";
    private String MODULE_VERSION = "1.0.0";
    private String MODULE_DATE = "9.9.2022";
    private String MODULE_LAST_EDIT_DATE = "9.9.2022";
    private String[] MODULE_AUTHORS = {"Robin Stecher"};
    private URLSource[] MODULE_SOURCES = {
            new URLSource("Own Know How"),
            new URLSource("Wikipedia", "https://wikipedia.org/")
    };

    // YOUR ATTRIBUTES

    // feel free, to add some attributes here :)



    // YOUR METHODS

    @Override
    public void runModule() {
        // This method is like the main method in java for you

        printLoop();
    }

    public void printLoop() {
        float i;
        for(i = 1; i < 100000.0; i += 1.0) {
            if(Math.sqrt(i) != Math.sqrt(i * i)) {
                System.out.println(Math.sqrt(i) + " is NOT the square root of " + i);
            }
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
