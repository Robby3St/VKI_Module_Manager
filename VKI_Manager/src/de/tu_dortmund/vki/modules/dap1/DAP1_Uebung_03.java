package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.modules.dap1.utils.uebung03.Box;
import de.tu_dortmund.vki.utils.URLSource;
import de.tu_dortmund.vki.utils.VkiModule;

// This is a demo module. Please copy it, to create your own modules.

// Your module information

public class DAP1_Uebung_03 extends VkiModule {
    private String MODULE_NAME = "Übung 3 DAP 1";
    private String MODULE_VERSION = "1.0.0";
    private String MODULE_DATE = "3.11.2022";
    private String MODULE_LAST_EDIT_DATE = "3.11.2022";
    private String[] MODULE_AUTHORS = {"Robin Stecher"};
    private URLSource[] MODULE_SOURCES = {};

    // YOUR ATTRIBUTES

    // feel free, to add some attributes here :)



    // YOUR METHODS

    @Override
    public void runModule() {
        // This method is like the main method in java for you

        testBox();
    }

    public void testBox() {
        Box box1 = new Box(30, 20, 10);
        Box box2 = new Box(11, 31, 21);

        System.out.println("Volume box1: " + box1.getVolume());
        System.out.println("Area size box1: " + box1.getAreaSize());
        System.out.println("Edges length box1: " + box1.getEdgesLength());
        System.out.println("Is cube box1: " + box1.isCube());
        System.out.println("Comparing box1 to box2: " + box1.compareTo(box2));
        System.out.println("Fits box1 in box2: " + box1.encloses(box2));
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
