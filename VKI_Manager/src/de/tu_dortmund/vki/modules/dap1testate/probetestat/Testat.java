package de.tu_dortmund.vki.modules.dap1testate.probetestat;

import java.util.LinkedList;
import java.util.List;

public class Testat
{
    public static int[] apply( int[] arr, int x ) {
        List<Integer> list = new LinkedList<Integer>();
        for (Integer i :
                arr) {
            if(i != x) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

    return result;







    }
}
