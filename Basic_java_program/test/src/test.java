class Base {
    private static void display() {
        System.out.println("Static or class method from Base");
    }

    public void print() {
        System.out.println("Non-static or instance method from Base");
    }
}

class Derived extends Base {
     private static void display() {
        System.out.println("Static or class method from Derived");
    }

    public void print() {
        System.out.println("Non-static or instance method from Derived");
    }

    private String hi;


    private void run(){
         System.out.println("Run");
    }
}

public class test {
    public static void main(String[] args) {
        Base obj = new Derived();
//        Base.display();
        obj.print();
        Derived obj1 = new Derived();
        
    }
}

//public class test {
//}
