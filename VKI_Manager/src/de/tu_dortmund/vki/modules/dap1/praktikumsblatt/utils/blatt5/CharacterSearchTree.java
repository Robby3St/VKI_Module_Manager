package de.tu_dortmund.vki.modules.dap1.praktikumsblatt.utils.blatt5;

public class CharacterSearchTree
{

    // Vorgaben

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public CharacterSearchTree(char[] arr) {
        content = null;
        leftChild = null;
        rightChild = null;

        for(int i = 0; i < arr.length; i++) {
            this.iterativeAdd(arr[i]);
        }
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

    public void add(char t, int q, String c) {
        CharacterSearchTree current = this;

        if(current.isEmpty()) {
            content = new HuffmanTriple(t);
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
            content.setCode(c);
        } else {
            if(current.content.getToken() == t) {
                for (int i = 0; i < q; i++)
                    content.incrementQuantity();
            } else if(current.content.getToken() > t) {
                leftChild.add(t, q, c);
            } else {
                rightChild.add(t, q, c);
            }

            content.setCode(c);
        }
    }

    public void showPreOrder() {
        CharacterSearchTree current = this;
        if(!current.isEmpty()) {
            System.out.println(current.content.toString());
            if(current.isLeaf())
                System.out.println('*');
            else {
                current.leftChild.showPreOrder();
                current.rightChild.showPreOrder();
            }
        }
    }

    public int height() {
        CharacterSearchTree current = this;

        if(current.isEmpty())
            return 0;

        int leftHeight = current.leftChild.height() + 1;
        int rightHeight = current.rightChild.height() + 1;

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    public int countCharacters() {
        CharacterSearchTree current = this;

        if(!current.isEmpty()) {
            int characters = current.content.getQuantity();
            characters += current.leftChild.countCharacters();
            characters += current.rightChild.countCharacters();

            return characters;
        } else {
            return 0;
        }
    }

    public int longestCode() {
        CharacterSearchTree current = this;
        int longest = 0;

        if(!current.isEmpty()) {
            if(current.content.getCode().length() > longest)
                longest = current.content.getCode().length();
            if(current.leftChild.longestCode() > longest)
                longest = current.leftChild.longestCode();
            if(current.rightChild.longestCode() > longest)
                longest = current.rightChild.longestCode();

            return longest;
        } else
            return 0;
    }

    public HuffmanTriple minimum() {
        CharacterSearchTree current = this;
        HuffmanTriple minimum = null;
        if(!current.isEmpty()) {
            while (!current.isEmpty()) {
                minimum = current.content;
                current = current.leftChild;
            }
        }

        return minimum;
    }

    public boolean hasOnlyCompleteNode() {
        CharacterSearchTree current = this;

        if(current.isEmpty())
            return true;
        if(current.leftChild.isLeaf() && !current.rightChild.isLeaf())
            return false;
        else if (!current.leftChild.isLeaf() && current.rightChild.isLeaf())
            return false;
        return current.leftChild.hasOnlyCompleteNode() && current.rightChild.hasOnlyCompleteNode();
    }

    public boolean containsCharacter(char t) {
        CharacterSearchTree current = this;

        if(current.isEmpty())
            return false;

        if(current.content.getToken() == t)
            return true;

        return current.leftChild.containsCharacter(t) || current.rightChild.containsCharacter(t);
    }

    public boolean equalStructure(CharacterSearchTree cst) {
        CharacterSearchTree current = this;

        if(current.isEmpty())
            return cst.isEmpty();
        else if(cst.isEmpty())
            return false;
        else
            return current.leftChild.equalStructure(cst.leftChild) && current.rightChild.equalStructure(cst.rightChild);
    }

    public CharacterSearchTree rotateNodeToRight() {
        CharacterSearchTree newRoot = this;
        if ( !isEmpty() && !leftChild.isEmpty() )
        {
            newRoot = leftChild;
            leftChild = newRoot.rightChild;
            newRoot.rightChild = this;
        }
        return newRoot;
    }
}
