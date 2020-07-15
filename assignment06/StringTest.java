public class StringTest {

    void callTest1 (StringBuffer sb) {

        sb = new StringBuffer("callTest1") ;
        System.out.println(sb) ;
    }

    void callTest2 (StringBuffer sb) {

        sb.append(" + callTest2") ;
        System.out.println(sb) ;
    }

    public static void main (String[] agrs) {

        StringTest test = new StringTest() ;

        StringBuffer s1 = new StringBuffer("test1") ;
        test.callTest1(s1) ;
        System.out.println("s1: " + s1) ;

        System.out.println() ;

        StringBuffer s2 = new StringBuffer("test2") ;
        test.callTest2(s2) ;
        System.out.println("s2: " + s2) ;

    }
}