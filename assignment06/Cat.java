public class Cat {

    String name ;

    Cat (String name) {
        this.name = name ;
    }

    static void foo1 (Cat c) {
        c.setName("Tigger") ;
    }

    static void foo2 (Cat c) {
        c = new Cat("Tigger") ;
    }

    void setName(String name) {
        this.name = name ;
    }

    String getName () {
        return name ;
    }

    public static void main (String[] agrs) {

        Cat c1 = new Cat("Chloe") ;
        foo1(c1) ;
        System.out.println("c1: " + c1.getName()) ;

        Cat c2 = new Cat("Chloe") ;
        foo2(c2) ;
        System.out.println("c2: " + c2.getName()) ;
    }
} 