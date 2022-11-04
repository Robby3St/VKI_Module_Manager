package de.tu_dortmund.vki.modules.dap1;

import de.tu_dortmund.vki.modules.dap1.utils.uebung03.*;
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
        System.out.println("\n");
        testPeriod();
        System.out.println("\n");
        testPointInTime();
        System.out.println("\n");
        testDate();
        System.out.println("\n");
        testGameOfLife();
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

    public void testPeriod() {
        Period p1 = new Period(100);
        System.out.println("P1 to String: " + p1.toString());

        Period p2 = new Period(60);
        System.out.println("P2 to String: " + p2.toString());

        Period p3 = new Period(120);
        System.out.println("P3 to String: " + p3.toString());
        p3.change(-10);
        System.out.println("P3 to String (changed by negative): " + p3.toString());
        p3.change(10);
        System.out.println("P3 to String (changed by positive): " + p3.toString());
    }

    public void testPointInTime() {
        PointInTime pit = new PointInTime(2022, 4, 1);
        System.out.println("Pit: " + pit.toString());
    }

    public void testDate() {
        Date dap1Uebung = new Date("DAP 1 Übung", new PointInTime(2022, 4, 14), new Period(120));
        System.out.println("DAP1 Test date: " + dap1Uebung.toString());
        dap1Uebung.change(14000);
        System.out.println("Changed date: " + dap1Uebung.toString());
    }

    public void testGameOfLife() {
        GameOfLife gof = new GameOfLife(5);
        gof.inject();
        gof.show();
        gof.futureGeneration(1);
        gof.show();
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
