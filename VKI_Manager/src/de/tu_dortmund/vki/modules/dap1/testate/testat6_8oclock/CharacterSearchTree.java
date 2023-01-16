package de.tu_dortmund.vki.modules.dap1.testate.testat6_8oclock;

public class CharacterSearchTree {

    //--- hier ergaenzen ---

    public int apply(int i) {
        if(!isEmpty()) {
            if(!this.leftChild.isEmpty() && this.leftChild.content.getQuantity() > i) {
                return leftChild.apply(i) + 1 + rightChild.apply(i);
            } else if (!this.rightChild.isEmpty() && this.rightChild.content.getQuantity() > i) {
                return leftChild.apply(i) + 1 + rightChild.apply(i);
            } else
                return leftChild.apply(i) + rightChild.apply(i);
        }

        return 0;
    }


    // --- Vorgaben ---
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void iterativeAdd(char t) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.incrementQuantity();
        }
    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

}
