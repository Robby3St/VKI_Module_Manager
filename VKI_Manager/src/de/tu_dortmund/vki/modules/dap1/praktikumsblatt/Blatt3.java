package de.tu_dortmund.vki.modules.dap1.praktikumsblatt;

public class Blatt3 {

    public static void main(String[] args) {
        System.out.println("Digit sum: " + digitSum(123));
        System.out.println("Power: " + power(2, -2));
        System.out.println("SumUpNegatives: " + sumUpNegatives(new int[]{1, 4, -2, -3, -1}, 3));
        System.out.println("CountPositives: " + countPositives(new int[]{1, 4, -2, 3, -1, 6}, 5));
        System.out.println("CountPositivesLimited: " + countPositivesLimited(new int[]{1, 4, -2, 3, -1, 6}, 1, 5));
        System.out.println("CountPositivesLimited: " + countPositivesLimited(new int[]{1, 4, -2, 3, -1, 6}, 1, 5));
        System.out.println("Max: " + max(new int[]{1, 4, -2, 7, -1, 6}, 5));
        System.out.println("IsSorted: " + isSorted(new int[]{-5, 1, 2, 5, 8}, 4));
        System.out.println("Contains: " + contains(new int[]{-5, 1, 2, 5, 8}, 4, -5));
        System.out.println("ContentCheck: " + contentCheck(new char[]{'a', 'b', 'c'}, new char[]{'a', 'b', 'c'}, 2));
        System.out.println("PalindromCheck: " + palindromeCheck(new char[]{'t', 'a', 'c', 'o', 'c', 'a', 't'}, 6));
        System.out.println("GetIndex: " + getIndex(new int[]{-5, 5, 1, 2, 5, 8}, 5, 5));
        System.out.println("ToString: " + toString(new int[]{1, 2, 4, 65}, 0));
    }

    public static int digitSum(int n) {
        if(n % 10 != 0) {
            return digitSum(n / 10) + n % 10;
        }
        return n;
    }

    public static double power(int a, int n) {
        if(n > 1)
            return a * power(a, n - 1);
         else if(n == 1)
            return a;
         else if(n == 0)
             return 1;
         else
             return 1 / (a * power(a, Math.abs(n + 1)));
    }

    public static int sumUpNegatives(int[] arr, int n) {
        if(n > 0)
            return arr[n] < 0 ? arr[n] + sumUpNegatives(arr, n - 1) : sumUpNegatives(arr, n - 1);
        return arr[0] < 0 ? arr[0] : 0;
    }

    public static int countPositives(int[] arr, int n) {
        if(n > 0)
            return arr[n] >= 0 ? 1 + countPositives(arr, n - 1) : countPositives(arr, n - 1);
        else
            return arr[0] >= 0 ? 1 : 0;
    }

    public static int countPositivesLimited(int[] arr, int d, int t) {
        if(t - 1 >= d)
            return arr[t] >= 0 ? 1 + countPositivesLimited(arr, d, t - 1) : countPositivesLimited(arr, d,t - 1);
        else
            return arr[0] >= 0 ? 1 : 0;
    }

    public static int max(int[] arr, int i) {
        if(i > 0) {
            return arr[i] > max(arr, i - 1) ? arr[i] : max(arr, i - 1);
        } else if(i == 0)
            return arr[i];
        return 0;
    }

    public static boolean isSorted(int[] arr, int i) {
        if(i > 0) {
            return arr[i-1] <= arr[i] && isSorted(arr, i - 1);
        } else if(arr.length >= 2)
            return arr[i] <= arr[i + 1];
        else
            return true;
    }

    public static boolean contains(int[] arr, int i, int x) {
        if(i > 0)
            return arr[i] == x || contains(arr, i - 1, x);
        else
            return arr[i] == x;
    }

    public static boolean contentCheck(char[] arr1, char[] arr2, int i) {
        if(arr1.length == arr2.length || (Math.abs(arr1.length - arr2.length)) - i >= 0) {
            if(i > 0)
                return arr1[i] == arr2[i] && contentCheck(arr1, arr2, i - 1);
            else
                return arr1[i] == arr2[i];
        }
        return false;
    }

    public static boolean palindromeCheck(char[] arr, int i) {
        if(i < 0 || arr.length <= i)
            return false;
        int j = arr.length - 1 - i;
        if(j >= i)
            return true;
        return arr[i] == arr[j] && palindromeCheck(arr, i - 1);
    }

    public static int getIndex(int[] arr, int i, int x) {
        if(i < 0 || i >= arr.length)
            return -1;
        else {
            int lowerIndex = getIndex(arr, i - 1, x);
            if(lowerIndex != -1 || arr[i] != x)
                return lowerIndex;
            else
                return i;
        }
    }

    public static String toString(int[] arr, int i) {
        if(i < 0 || i >= arr.length)
            return "";
        if(i == arr.length - 1)
            return arr[i] + toString(arr, i + 1);
        return arr[i] + ", " + toString(arr, i + 1);
    }
}
