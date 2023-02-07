package de.tu_dortmund.vki.modules.dap1.tests;

public class Polymorphie {
    public static void m( double p ) { System.out.print("A "); }
    public static void m( int p) { System.out.print("L "); }
    public static void m( char p ) { System.out.print("X "); }

    public static void main(String[] args) {
        boolean firstTask = false;

        if(firstTask) {
            m('a');
            m(7/3.0);
            m('a' / 'b');
            m(new Integer(5));
        } else {
            All all = new All();
            Most most = new Most();
            Special special = new Special();

            Top x = new Middle();
            Top y = new Bottom();
            Middle z = new Bottom();

            x.m( most );
            x.m( special );
            y.m( all );
            y.m( special );
            z.m( all );
            z.m( most );
        }
    }
}

class All {}
class Most extends All {}
class Special extends Most {}

class Top {
    public void m(All p) { System.out.print("A "); }
}

class Middle extends Top {
    public void m( All p ) { System.out.print("M "); }
    public void m( Special p ) { System.out.print("L "); }
}

class Bottom extends Middle {
    public void m( Most p ) { System.out.print("V "); }
    public void m( Special p ) { System.out.print("X "); }
}

