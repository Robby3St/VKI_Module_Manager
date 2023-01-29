package de.tu_dortmund.vki.modules.dap1.testate.testateva7;

public class DoublyLinkedList {
    // hier fuer Testat ergaenzen

    public void apply(Object obj) {
//        Element e = new Element(obj);
//        if (this.size() > 1) {
//            Element pred = this.last.getPred();
//            Element l = this.last;
//            pred.connectAsSucc(e);
//            e.connectAsSucc(l);
//            size++;
//        } else if (this.size() == 1) {
//            Element current = first;
//            first = e;
//            first.connectAsSucc(current);
//            size++;
//        } else {
//            first = e;
//            last = e;
//            size++;
//        }

        Element e = new Element(obj);
        Element current = this.first;
        boolean contains = false;
        if(size()>= 3) {
            while (current.hasSucc()){
                if(current.equals(obj)) {
                    contains = true;
                }
                current = current.getSucc();
            }
            Element third = this.first.getSucc().getSucc().getSucc().getSucc();
            this.first.getSucc().connectAsSucc(e);
            e.connectAsSucc(third);
            this.size++;
        }
    }


    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content )
    {
        Element e = new Element( content );
        if ( isEmpty() )
        {
            first = last = e;
        }
        else
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    // Element

    private class Element
    {
        private Object content;
        private Element pred, succ;

        Element( Object c )
        {
            content = c;
            pred = succ = null;
        }

        Object getContent()
        {
            return content;
        }

        void setContent( Object c )
        {
            content = c;
        }

        boolean hasSucc()
        {
            return succ != null;
        }

        Element getSucc()
        {
            return succ;
        }

        void disconnectSucc()
        {
            if ( hasSucc() )
            {
                succ.pred = null;
                succ = null;
            }
        }

        void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null )
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        boolean hasPred()
        {
            return pred != null;
        }

        Element getPred()
        {
            return pred;
        }

        void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }

    }
}
