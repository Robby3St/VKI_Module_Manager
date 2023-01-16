package de.tu_dortmund.vki.modules.dap1.praktikumsblatt.utils.blatt5;

public class TreeTest
{
    public static void main( String[] args )
    {
        testMethods();
    }
    
    private static void testMethods()
    {
        char[] chars = {'n','d','a','f','b','e','k','i','x','o','s','z','r'};
        CharacterSearchTree cst = new CharacterSearchTree( chars );
        System.out.println("cst.show() - SOLL-Ergebnis: a b d e f i k n o r s x z");
        cst.show();
        
        // weitere Tests ergaenzen

        // Task 2 (void add)

        System.out.println("\nShowing Task 2");
        cst.add('x', 1, "100");
        cst.add('n', 2, "001");
        cst.show();


        // Task 3 (show PreOrder)

        System.out.println("\nShowing Task 3");
        cst.showPreOrder();


        // Task 4 (height)

        System.out.println("\nShowing Task 4");
        System.out.println("Height: " + cst.height());


        // Task 5 (countCharacters)

        System.out.println("\nShowing Task 5");
        System.out.println("Characters: " + cst.countCharacters());


        // Task 6 (longestCode)

        System.out.println("\nShowing Task 6");
        System.out.println("Longest: " + cst.longestCode());


        // Task 7 (longestCode)

        System.out.println("\nShowing Task 7");
        System.out.println("Minimum: " + cst.minimum().toString());


        // Task 8 (hasOnlyCompleteNode)

        System.out.println("\nShowing Task 8");
        System.out.println("Has only nodes with two neighbours: " + cst.hasOnlyCompleteNode());


        // Task 9 (containsCharacter)

        System.out.println("\nShowing Task 9");
        System.out.println("Contains character 't': " + cst.containsCharacter('t'));
        System.out.println("Contains character 'n': " + cst.containsCharacter('n'));


        // Task 10 (hasOnlyCompleteNode)

        char[] chars2 = {'u','d','a','f','b','y', 'y'};
        CharacterSearchTree cst2 = new CharacterSearchTree( chars2 );

        System.out.println("\nShowing Task 10");
        System.out.println("Has equal structure: " + cst.equalStructure(cst2));
        System.out.println("Has equal structure: " + cst.equalStructure(cst));


        // Task 11 (rotateNodeRight)

        System.out.println("\nShowing Task 11");
        System.out.println("Rotated: ");
        cst.rotateNodeToRight().show();
    }
}

