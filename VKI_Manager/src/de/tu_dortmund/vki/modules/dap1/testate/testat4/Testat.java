package de.tu_dortmund.vki.modules.dap1.testate.testat4;

public class Testat
{
    public static Fraction apply( Fraction[] arr, Fraction f, int i )
    {
        if(arr.length == 0) {
            return new Fraction(-1);
        }
        if(i > arr.length - 1) {
            return new Fraction(-1);
        }
        if(i < 0) {
            return new Fraction(-1);
        }
        if(i == 0) {
            return f.equals(arr[i]) ? new Fraction(1) : new Fraction(0);
        }

        return f.equals(arr[i]) ? new Fraction(1).add(apply(arr, f, i - 1)) : apply(arr, f, i - 1);
    }
}