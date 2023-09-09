import java.util.ArrayList;

abstract class AnimalFarm {
    private String name;
    private double weight;
    private String color;

    public AnimalFarm(String name, double weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public abstract void speak();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Color: " + color);
    }

    public String getName() {
        return name;
    }
}

class Dog extends AnimalFarm {
    private String barkSound;

    public Dog(String name, double weight, String color, String barkSound) {
        super(name, weight, color);
        this.barkSound = barkSound;
    }

    @Override
    public void speak() {
        System.out.println("Dog " + getName() + " says: " + barkSound);
    }
}

class Cat extends AnimalFarm {
    private String meowSound;

    public Cat(String name, double weight, String color, String meowSound) {
        super(name, weight, color);
        this.meowSound = meowSound;
    }

    @Override
    public void speak() {
        System.out.println("Cat " + getName() + " says: " + meowSound);
    }
}

class Chicken extends AnimalFarm {
    private String cluckSound;

    public Chicken(String name, double weight, String color, String cluckSound) {
        super(name, weight, color);
        this.cluckSound = cluckSound;
    }

    @Override
    public void speak() {
        System.out.println("Chicken " + getName() + " says: " + cluckSound);
    }
}

class Farm {
    private ArrayList<AnimalFarm> animals;

    public Farm() {
        animals = new ArrayList<>();
    }

    public void addAnimal(AnimalFarm animal) {
        animals.add(animal);
    }

    public AnimalFarm findAnimalByName(String name) {
        for (AnimalFarm animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void makeAllAnimalsSpeak() {
        for (AnimalFarm animal : animals) {
            animal.speak();
        }
    }

    public void displayAllAnimalInfo() {
        for (AnimalFarm animal : animals) {
            animal.displayInfo();
            System.out.println();
        }
    }
}

public class Animal {
    public static void main(String[] args) {
        Farm farm = new Farm();

        // Add animals to the farm
        farm.addAnimal(new Dog("Buddy", 25.5, "Brown", "Woof!"));
        farm.addAnimal(new Cat("Whiskers", 4.0, "Gray", "Meow"));
        farm.addAnimal(new Chicken("Clucky", 1.2, "White", "Cluck"));

        // Make all animals speak
        farm.makeAllAnimalsSpeak();

        // Find and display an animal by name
        AnimalFarm foundAnimal = farm.findAnimalByName("Buddy");
        if (foundAnimal != null) {
            System.out.println("Found Animal:");
            foundAnimal.displayInfo();
        }

        // Display information for all animals on the farm
        farm.displayAllAnimalInfo();
    }
}