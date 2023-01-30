package de.tu_dortmund.vki.modules.dap1.testate.testat8;

public class LambdaMethods
{

    public static int makeInt( IntIntPairs p )
    {
        // Methode nicht loeschen und compilierbar ergaenzen

        return p.accumulate((k, v) -> k);
 
    }
    
    public static IntIntPairs  makePairs( IntIntPairs p )
    {
        // Methode nicht loeschen und compilierbar ergaenzen

        return p.extract((k, v) -> v > 0);
 
    }
        
    public static void apply( IntIntPairs p )
    {
        // hier ergaenzen
        // Methode nicht loeschen

        p.manipulate((k, v) -> k * 3, (k, v) -> v * 3);

    }
 
}
