class Car {
    void run() {
        System.out.println("car is running");
    }

    void hi() {
        System.out.println("cHi");
    }
}


class Audi extends Car {
    void run() {
        System.out.println("Audi is running safely with 100km");
    }

    public static void main(String args[]) {
        Car b = new Audi();    //upcasting
//        b.hi();
//        Car b = new Audi();
        b.run();
    }
}

