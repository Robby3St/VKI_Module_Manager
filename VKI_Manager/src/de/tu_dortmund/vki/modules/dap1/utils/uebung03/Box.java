package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

public class Box {
    private int width;
    private int height;
    private int depth;


    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // --- Class methods

    public int getVolume() {
        return this.depth * this.width * this.height;
    }

    public int getAreaSize() {
        return (this.width * this.depth) + (this.width * this.height) + (this.height * this.depth);
    }

    public int getEdgesLength() {
        return (this.width * 4) + (this.height * 4) + (this.depth * 4);
    }

    public boolean isCube() {
        return this.width == this.height && this.height == this.depth && this.depth == this.width ? true : false;
    }

    public int compareTo(Box other) {
        int v1 = this.getVolume();
        int v2 = other.getVolume();

        if(v1 == v2) {
            return 0;
        } else if(v1 > v2) {
            return v1;
        } else {
            return v1 - v2;
        }
    }

    public boolean encloses(Box other) {
        int[] box1 = {other.width, other.height, other.depth};
        int[] box2 = {this.width, this.height, this.depth};

        boolean foundPossible = false;
        int turns = 3;

        do {
            for(int i = 0; i < box1.length; i++) {
                if(box1[i] >= box2[i]) {
                    foundPossible = true;
                } else {
                    foundPossible = false;
                }
            }

            if(foundPossible) {
                turns = 0;
            }

        // rotate the box
        int helper = box2[0];
        box2[0] = box2[1];
        box2[1] = box2[2];
        box2[2] = helper;

        turns--;
        } while(turns > 0);

        return foundPossible;

//        for(int i = 0; i < box1.length; i++) {
//            int turns = 3;
//            do {
//                if(box1[i] >= box2[i]) {
//
//                }
//            } while(turns > 0) {
//
//            }
//        }
    }








    // --- Getters & Setters

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
