package de.tu_dortmund.vki.modules.dap1.praktikumsblatt.utils.blatt7;

import java.util.HashSet;
import java.util.Set;

public class Testumgebung
{
    public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8);
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18); 
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,32); testPairs.put(1,1);
        IntIntPairs testPairsCopy = copy(testPairs);

        System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );

        System.out.print("Beispiel: " + sumUp( testPairs ) ); System.out.println();

        System.out.println("countEvens: " + countEvens(testPairs));
        System.out.println("Pairs: " + testPairs.toString());
        deleteAllValuesWith6(testPairs);
        System.out.println("Pairs: " + testPairs.toString());
        add10ToAll(testPairs);
        System.out.println("Pairs: " + testPairs.toString());
        testPairs = copy(testPairsCopy);
        System.out.println(testPairs.toString());
        System.out.println("getPairsWithValuesGreater3: " + getPairsDevidableByThree(testPairs));
        System.out.println(testPairs.toString());
        deleteAllNegativeValues(testPairs);
        System.out.println(testPairs.toString());
        doubleAllValids(testPairs);
        System.out.println(testPairs.toString());
        removeDoublicatedValues(testPairs);
        System.out.println(testPairs.toString());
        System.out.println("sumAll: " + sumAll(testPairs));
        System.out.println("All over 5: " + copyAllWithValueAboveFive(testPairs).toString());

//        ---- Task 2 -----

        testPairs = copy(testPairsCopy);
        System.out.println(testPairs.toString());
        int n = 10;
        addNToValue(testPairs, n);
        System.out.println("addNToValue(n: " + n + "): " + testPairs.toString());
        System.out.println("uniqueKey 13: " + uniqueKey(testPairs, 13));
        System.out.println("uniqueKey 11: " + uniqueKey(testPairs, 11));

        doubleGreaterN(testPairs, 0);
        System.out.println("doubleGreaterN: " + testPairs.toString());
        System.out.println("Copied instance: " + testPairsCopy.toString());

        testPairs = concat(testPairs, testPairsCopy);
        System.out.println("Concat: " + testPairs.toString());


    }
    
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }

    public static int countEvens(IntIntPairs pairs) {
        return pairs.accumulate( (k, v) -> k % 2 == 0 ? 1 : 0);
    }

    public static void deleteAllValuesWith6(IntIntPairs pairs) {
        pairs.remove((k, v) -> k == 6);
    }

    public static void add10ToAll(IntIntPairs pairs) {
        pairs.manipulate((k, v) -> k + 10, (k, v) -> v);
    }

    public static IntIntPairs getPairsDevidableByThree(IntIntPairs pairs) {
        return pairs.extract((k, v) -> v % 3 == 0);
    }

    public static IntIntPairs copy(IntIntPairs pairs) {
        return pairs.extract((k, v) -> true);
    }

    public static void deleteAllNegativeValues(IntIntPairs pairs) {
        pairs.remove((k, v) -> v < 0);
    }

    public static void doubleAllValids(IntIntPairs pairs) {
        pairs.manipulate((k, v) -> k, (k, v) -> v * 2);
    }

    public static void removeDoublicatedValues(IntIntPairs pairs) {
        HashSet<Integer> set = new HashSet<Integer>();
        pairs.remove((k, v) -> { if(set.contains(v)) { return true; } else { set.add(v); return  false; } });
    }

    public static int sumAll(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> v);
    }

    public static IntIntPairs copyAllWithValueAboveFive(IntIntPairs pairs) {
        return pairs.extract((k, v) -> v > 5);
    }

//    ---- Task 2 ------


    
     public static void addNToValue( IntIntPairs pairs, int n )
     {
         pairs.manipulate((k, v) -> k, (k, v) -> v + n);
     }

     public static boolean uniqueKey( IntIntPairs pairs, int n )
     {
         return pairs.accumulate((k, v) -> v == n ? 1 : 0) == 1;
     }

     public static void doubleGreaterN( IntIntPairs pairs, int n )
     {
         pairs.accumulate((k, v) -> {
             if(k > n) {
                 if(pairs.uncomplete())
                    pairs.put(k, v * 2); // Only when capacity is available
             }
             return 0;
         });
     }

     public static int countAll(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> 1);
     }

     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
     {
         IntIntPairs newPairs = new IntIntPairs(countAll(first) + countAll(second));
         newPairs.combine(first);
         newPairs.combine(second);
         return newPairs;
     }
}
