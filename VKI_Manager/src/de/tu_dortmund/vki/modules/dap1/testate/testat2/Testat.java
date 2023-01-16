package de.tu_dortmund.vki.modules.dap1.testate.testat2;

public class Testat
{
    public static Fraction apply(Fraction[] arr, Fraction x )
    {
        if(arr.length < 4 || arr.length % 2 != 0) {
            return x.divideBy(new Fraction(2));
        } else {
            // return sum of both mid elements
            Fraction f1 = arr[computeMid(arr.length)];
            Fraction f2 = arr[computeMid(arr.length) + 1];

            return f1.add(f2);
        }
    }

    private static int computeMid(int length) {
        return (length - 1) / 2;
    }
}