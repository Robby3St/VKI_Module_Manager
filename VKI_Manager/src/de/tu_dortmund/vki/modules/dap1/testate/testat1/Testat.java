package de.tu_dortmund.vki.modules.dap1.testate.testat1;

public class Testat
{
    public static int[] apply ( int[] arr , int x)
    {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                result[i] = 0;
            } else {
                result[i] = arr[i];
            }
        }

        return result;
    }
}