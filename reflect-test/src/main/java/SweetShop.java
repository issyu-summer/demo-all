class Candy {
    static {   System.out.println("Loading Candy"); }
}

class Gum {
    static {   System.out.println("Loading Gum"); }
}

class Cookie {
    static {   System.out.println("Loading Cookie"); }
}

/**
 * @author Administrator
 */
public class SweetShop {
    static {
        System.out.println("Loading SweetShop");
    }
    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        //new Gum();
        try {
            Class.forName("Gum");
        } catch(ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
}
//执行结果如下、
//静态成员会在类第一次被加载时执行,@Bean
//    Loading SweetShop
//    inside main
//    Loading Candy
//    After creating Candy
//        Loading Gum
//        After Class.forName("Gum")
//        Loading Cookie
//        After creating Cookie

