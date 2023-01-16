package de.tu_dortmund.vki.modules.dap1.praktikumsblatt;

import de.tu_dortmund.vki.modules.dap1.praktikumsblatt.utils.blatt2.Fraction;

public class Blatt2 {
    public static Fraction countNegatives(Fraction[] arr) {
        int negatives = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].toDouble() < 0)
                negatives++;
        }

        return new Fraction(negatives);
    }

    public static Fraction sumUpNegatives(Fraction[] arr) {
        Fraction sum = new Fraction();
        for(Fraction f : arr) {
            if(f.toDouble() < 0) {
                sum.add(f);
            }
        }

        return sum;
    }

    public static Fraction maximum(Fraction[] arr) {
        Fraction max = arr[0];
        if(arr.length == 0)
            return null;
        for(Fraction f : arr) {
            if(f.toDouble() > max.toDouble())
                max = f;
        }

        return max;
    }

    public static Fraction countMaximum(Fraction[] arr) {
        int count = 0;
        Fraction max = maximum(arr);
        for(Fraction f : arr) {
            if(f.equals(max))
                count++;
        }

        return new Fraction(count);
    }

    public static boolean isSorted(Fraction[] arr) {
        Fraction last = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(last.toDouble() > arr[i].toDouble())
                return false;
            last = arr[i];
        }

        return true;
    }

    public static Fraction[] increaseArray(Fraction[] arr, Fraction z) {
        Fraction[] result = new Fraction[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = arr[i].add(z);
        }

        return result;
    }

    private static boolean containsPositive(Fraction[] arr) {
        for(Fraction f : arr) {
            if(f.toDouble() >= 0)
                return true;
        }

        return false;
    }

    public static Fraction[] doubleIfContainsPositive(Fraction[] arr) {
        if(containsPositive(arr)) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].multiply(new Fraction(2));
            }
        }

        return arr;
    }

    public static String toString(Fraction[] arr) {
        String result = "";
        for(int i = 0; i < arr.length; i++) {
            result += arr[i].toString();
            if(i < arr.length - 1)
                result += ", ";
        }

        return result;
    }

    public static Fraction[] selectNegatives(Fraction[] arr) {
        Fraction[] result = new Fraction[(int) countNegatives(arr).toDouble()];
        int state = 0;
        for(Fraction f : arr) {
            if(f.toDouble() < 0) {
                result[state] = f;
                state++;
            }
        }

        return result;
    }

    public static Fraction countSequences(Fraction[] arr) {
        int sequences = 0;
        int indexCurrentSequenceStart = -1;

        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(new Fraction(0))) { // Fraction not 0
                if(indexCurrentSequenceStart == i - 1) // fraction before was already not zero
                    sequences++; // found sequence
                else if(indexCurrentSequenceStart == -1) // element before was zero, here a potentially sequence starts
                    indexCurrentSequenceStart = i; // remember for later, if the second element is also not a zero
            } else {
                indexCurrentSequenceStart = -1; // current element is a zero, reset current sequence
            }
        }

        return new Fraction(sequences);
    }
}
