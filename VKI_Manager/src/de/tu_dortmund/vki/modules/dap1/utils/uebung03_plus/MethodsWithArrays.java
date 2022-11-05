package de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus;

import java.util.HashMap;

public class MethodsWithArrays {
    public static int most(int[] arr) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        int[] max = {arr[0], 0};

        if(arr == null | arr.length == 0) {
            return 0;
        }

        for(Integer i : arr) {
            if(frequency.containsKey(i)) {
                frequency.replace(i, frequency.get(i), frequency.get(i) + 1);
            } else {
                frequency.put(i, 1);
            }
        }

        for(Integer key : frequency.keySet()) {
            if(frequency.get(key) > max[1]) {
                max[0] = key;
                max[1] = frequency.get(key);
            }
        }

        return max[1];
    }
}
