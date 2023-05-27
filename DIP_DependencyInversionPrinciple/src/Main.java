interface Toy {
    String play();
}

class Kid {
    private Toy toy;

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public void play() {
        if (toy != null) {
            System.out.println("Kid is playing with " + toy.play());
        } else {
            System.out.println("Kid has no toy to play with");
        }
    }
}

class Robot implements Toy {
    public String play() {
        return "Robot";
    }
}

public class Main {
    public static void main(String[] args) {
        Toy robot = new Robot();
        Kid k = new Kid();
        k.setToy(robot);
        k.play();
    }
}