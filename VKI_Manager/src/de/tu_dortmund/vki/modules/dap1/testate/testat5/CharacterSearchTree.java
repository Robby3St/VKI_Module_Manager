package de.tu_dortmund.vki.modules.dap1.testate.testat5;

public class CharacterSearchTree
{

    //--- hier ergaenzen ---

    public int apply() {
        CharacterSearchTree current = this;
        int count = 0;

        if(!this.isEmpty()) {
            if(!current.isLeaf()) {
                count += current.content.getQuantity() > 1 ? 1: 0;
                if(!current.leftChild.isEmpty())
                    count += current.leftChild.apply();
                if(!current.rightChild.isEmpty())
                    count += current.rightChild.apply();
            }

            return count;
        } else
            return 0;
    }

    
    
    // --- Vorgaben ---

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getContent()
    {
        if ( !isEmpty() )
        {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() 
    {
        return content == null;
    }

    public boolean isLeaf() 
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void iterativeAdd( char t )
    {
        CharacterSearchTree current = this;
        while ( !current.isEmpty() && current.content.getToken() != t )
        {
            if ( current.content.getToken() > t )
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }
        }
        if ( current.isEmpty() ) 
        {
            current.content = new HuffmanTriple( t );
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
        else
        {
            current.content.incrementQuantity();
        }
    }

    public void show()
    {
        if ( !isEmpty() ) 
        {
            leftChild.show();
            System.out.println( content.toString() );
            rightChild.show();
        }
    }
}
