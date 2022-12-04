package de.tu_dortmund.vki.modules.dap1.praktikumsblatt;

public class Blatt1 {
    public static void main(String[] args) {
        System.out.println("Interval: " + interval(5, 11));
        System.out.println("DigitSum: " + digitSum(345));
        System.out.println("DigitToString: " + digitToString(4));
        System.out.println("IntToString: " + intToString(-144));
        System.out.println("DigitSumToString: " + digitSumToString(144));
        System.out.println("IsHarshad: " + isHarshad(777));
        System.out.println("ComputeHarshads: ");
        computeHarshads(777);
        System.out.println("Euler: " + computeEuler(40));
    }

    public static int interval(int a, int b) {
        int greater = a > b ? a : b;
        int lower = a < b ? a : b;
        int sum = 0;

        for(int i = lower; i <= greater; i++) {
            sum += i;
        }

        return sum;
    }

    public static int digitSum(int x) {
        int num = Math.abs(x);
        int digitSum = 0;

        while(num > 0) {
            digitSum += num % 10;
            num /= 10;
        }

        return digitSum;
    }

    public static String digitToString(int z1) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if(z1 >= 0 && z1 <= 9) {
            return digits[z1];
        }
        return "";
    }

    public static String intToString(int x) {
        int num = Math.abs(x);
        String result = "";

        while(num > 0) {
            result += "-" + digitToString(num % 10);
            num /= 10;
        }

        String[] reversed = result.split("-");
        result = "";
        if(x < 0) {
            result += "minus";
        }
        for(int i = reversed.length - 1; i > 0; i--) {
            if(reversed.length > 2)
                result += "-" + reversed[i];
            else
                result += reversed[i];
        }

        return result;
    }

    public static String digitSumToString(int x) {
        return intToString(digitSum(x));
    }

    public static boolean isHarshad(int x) {
        return x % digitSum(x) == 0 ? true : false;
    }

    public static void computeHarshads(int n) {
        for(int i = 0; i <= n; i++) {
            if(isHarshad(i + 1))
                System.out.print(i + 1 + "  ");
        }
        System.out.println();
    }

    public static double computeEuler(int n) {
        double sum = 0;
        for(int i = 1; i <= n; i++) {
            double product = 1;
            for(int j = 1; j <= i; j++) {
                product *= j;
            }
            sum = sum + (1 / product);
            System.out.println("Sum: " + sum);
        }
        return sum;
    }
}
