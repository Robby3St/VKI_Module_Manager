package de.tu_dortmund.vki.modules.dap1.utils.uebung03_plus;

import java.util.HashMap;
import java.util.HashSet;

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

    public static int lastHit(int arr[], int[] numbers) {
        HashSet<Integer> num = new HashSet<Integer>();

        if(arr == null | arr.length == 0 | numbers == null | numbers.length == 0) {
            return -1;
        }

        for(Integer i : numbers) {
            num.add(i);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            if(num.contains(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    public static int zeroSequence(int[] arr) {
        int startPosGreatest = -1;
        int greatestChain = 0;
        int startPosCurrent = -1;
        int currentChain = 0;

        for(int i = 0; i < arr.length; i++) {
            if(currentChain == 0 & arr[i] == 0) {
                startPosCurrent = i;
                currentChain++;
            }
            if(currentChain > 0 & arr[i] == 0) {
                currentChain++;
            } else {
                currentChain = 0;
            }
            if(currentChain >= greatestChain) {
                greatestChain = currentChain;
                startPosGreatest = startPosCurrent;
            }
        }

        return  startPosGreatest;
    }
}
