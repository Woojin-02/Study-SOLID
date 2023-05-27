abstract class Animal {
    abstract void cry();
}

class Dog extends Animal {
    @Override
    void cry() {
        System.out.println("bark!!!");
    }
}

class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("Meow...");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.cry(); // "bark!!!" 출력
        cat.cry(); // "Meow..." 출력
    }
}