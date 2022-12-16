package de.tu_dortmund.vki.modules.dap1.praktikumsblatt;

import de.tu_dortmund.vki.modules.dap1.praktikumsblatt.utils.blatt2.Fraction;

public class Blatt4 {
    public static void main(String[] args) {
        Fraction[] arr = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(1), new Fraction(5, 10)};
        System.out.println("Maximum: " + maximum(arr, arr.length - 1).toString());

        Fraction[] arrLastPositive = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(-1), new Fraction(-5, 10)};
        System.out.println("LastPositive: " + lastPositive(arrLastPositive, arrLastPositive.length - 1).toString());

        Fraction[] arrFirstPositive = {new Fraction(-1, 2), new Fraction(-1, 4), new Fraction(-1), new Fraction(5, 10)};
        System.out.println("FirstPositive: " + firstPositive(arrFirstPositive, arrFirstPositive.length - 1).toString());

        Fraction[] arrUnsorted = {new Fraction(-1, 2), new Fraction(-1, 4), new Fraction(-1), new Fraction(5, 10)};
        Fraction[] arrSorted = {new Fraction(-1, 12), new Fraction(1, 12), new Fraction(1, 8), new Fraction(1, 3)};
        System.out.println("IsSorted1: " + isSorted(arrUnsorted, arrUnsorted.length - 1));
        System.out.println("IsSorted2: " + isSorted(arrSorted, arrSorted.length - 1));

        Fraction[] arrContains = {new Fraction(1, 2), new Fraction(1, 8), new Fraction(1), new Fraction(5, 10)};
        System.out.println("Contains: " + contains(arr, arr.length - 1, new Fraction(1, 8)));
        System.out.println("Contains2: " + contains(arrContains, arrContains.length - 1, new Fraction(1, 8)));

        System.out.println("CountPositives: " + countPositives(arrLastPositive, 0, arrLastPositive.length - 1));

        Fraction[] arrContentCheck1 = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(1), new Fraction(5, 10)};
        Fraction[] arrContentCheck2 = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(1), new Fraction(5, 10)};
        System.out.println("ContentCheck: " + contentCheck(arrContentCheck1, arrContentCheck2, arrContentCheck1.length - 1));

        Fraction[] arrPalindrome = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(1, 4), new Fraction(1, 2)};
        System.out.println("Palindrome: " + palindromeCheck(arrPalindrome, arrPalindrome.length - 1));

        Fraction[] arrGetIndex = {new Fraction(1, 2), new Fraction(1, 4), new Fraction(1, 4), new Fraction(1, 2)};
        System.out.println("GetIndex: " + getIndex(arrGetIndex, arrGetIndex.length - 1, new Fraction(1, 4)));
    }

    public static Fraction maximum(Fraction[] arr, int i) {
        if(arr.length == 0)
            return null;
        if(arr.length == 1 || i == 0)
            return arr[0];
        return arr[i].toDouble() > maximum(arr, i - 1).toDouble() ? arr[i] : maximum(arr, i - 1);
    }

    public static Fraction lastPositive(Fraction[] arr, int i) {
        if(arr.length == 0 || i == 0)
            return null;
        if(arr[i].toDouble() >= 0)
            return arr[i];
        return lastPositive(arr, i - 1);
    }

    public static Fraction firstPositive(Fraction[] arr, int i) {
        int j = arr.length - 1 - i;

        if(arr.length == 0)
            return null;
        if(j == arr.length - 1 && arr[j].toDouble() < 0)
            return null;

        return arr[j].toDouble() >= 0 ? arr[j] : firstPositive(arr, i - 1);
    }

    public static boolean isSorted(Fraction[] arr, int i) {
        int j = arr.length - 1 - i;

        if(arr.length == 0 || arr.length == 1)
            return true;

        if(i == 0)
            return arr[j].toDouble() >= arr[j - 1].toDouble();

        if(j > 0)
            return arr[j].toDouble() >= arr[j - 1].toDouble() && isSorted(arr, i - 1);

        return isSorted(arr, i - 1);
    }

    public static boolean contains(Fraction[] arr, int i, Fraction x) {
        if(arr.length == 0)
            return false;

        if(i == 0)
            return arr[0].equals(x);

        if(arr[i].equals(x))
            return true;
        return contains(arr, i - 1, x);
    }

    public static int countPositives(Fraction[] arr, int d, int t) {
        if(arr.length == 0 || t >= arr.length  || d >= arr.length || d > t)
            return 0;

        if(d == t)
            return arr[t].toDouble() >= 0 ? 1 : 0;
        return arr[t].toDouble() >= 0 ? 1 + countPositives(arr, d, t - 1) : countPositives(arr, d, t - 1);
    }

    public static boolean contentCheck(Fraction[] arr1, Fraction[] arr2, int i) {
        if(arr1.length == 0 && arr2.length == 0)
            return true;

        if(i > arr1.length - 1 || i > arr2.length - 1)
            return false;

        if(i == 0)
            return arr1[i].equals(arr2[i]);
        return arr1[i].equals(arr2[i]) && contentCheck(arr1, arr2, i - 1);
    }

    public static boolean palindromeCheck(Fraction[] arr, int i) {
        int j = arr.length - 1 - i;

        if(i > arr.length)
            return false;

        if(arr.length == 0)
            return true;

        if(j >= i)
            return true;
        return arr[j].equals(arr[i]) && palindromeCheck(arr, i - 1);
    }

    public static int getIndex(Fraction[] arr, int i, Fraction x) {
        int j = arr.length - 1 - i;

        if(arr.length == 0)
            return -1;

        if(i >= arr.length)
            return -1;

        if(j == arr.length - 1)
            return arr[j].equals(x) ? j : -1;
        return arr[j].equals(x) ? j : getIndex(arr, i - 1, x);
    }
}
