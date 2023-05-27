public class Main {

    public static void main(String[] args) {

        Car[] drivers = new Car[3];

        drivers[0] = new Sonata();
        drivers[1] = new Grandeur();
        drivers[2] = new BMW();

        for (int i = 0; i < drivers.length; i++) {
            drivers[i].drive();
        }

    }

}

class Car {
    String myCar = "Car";

    void drive() {
        System.out.printf("I can drive %s.\n", myCar);
    }
}

class Sonata extends Car {
    public Sonata() {
        myCar = "Sonata";
    }
}

class Grandeur extends Car {
    public Grandeur() {
        myCar = "Grandeur";
    }
}

class BMW extends Car {
    public BMW() {
        myCar = "BMW";
    }
}