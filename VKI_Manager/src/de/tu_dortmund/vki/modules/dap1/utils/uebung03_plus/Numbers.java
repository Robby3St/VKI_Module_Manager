package de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus;

import java.util.Arrays;

public class Numbers {
    private int[] values;

    public Numbers(int n) {
        this.values = new int[n];
    }

    public void reset(int index) {
        if(this.values != null && this.values.length > 0) {
            if(index >= 0 && index < this.values.length - 1) {
                this.values[index] = 0;
            }
        }
    }

    public boolean insert(int value) {
        if(this.values == null || this.values.length == 0) {
            return false;
        }

        for(int i = 0; i < this.values.length; i++) {
            if(this.values[i] == 0) {
                this.values[i] = value;
                return true;
            }
        }

        return false;
    }

    public Numbers copy() {
        // Reverse engineering the insert method to create a copy
        Numbers n = new Numbers(this.values.length);
        for(int i = 0; i < this.values.length; i++) {
            if(i - 1 >= 0) {
                if(this.values[i - 1] == 0) {
                    n.insert(this.values[i]);
                    n.reset(i - 1);
                }
            }
            if(i == this.values.length - 1 && this.values[i] == 0) {
                // Last index gets a direct 0 insertion
                n.insert(0);
            } else if (this.values[i] == 0) {
                // Use 1 as a placeholder to replace in next step (stop overwriting behavior during insertion)
                n.insert(1);
            } else {
                // Insert normal values
                n.insert(this.values[i]);
            }
        }

        return n;
    }

    public String toString() {
        return Arrays.toString(this.values);
    }
}
