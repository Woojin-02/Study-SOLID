# Study-SOLID(객체지향 프로그래밍의 5가지 원칙)

- 단일 책임 원칙(SRP)<br/>
 1) 실행 코드
```
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
```

 2) 클래스도<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/d74e27f5-0318-4391-be9f-480c93970958)

 3) 코드 실행(순차도)<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/2c834113-2e39-47b7-be80-da521fb2fac2)

 4) 실행 결과
```
bark!!!
Meow...
```
<br/>
<br/>
- 개방/폐쇄 원칙(OCP)

 1) 실행 코드
```
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
```

 2) 클래스도<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/e79e68e1-a1fb-4c2b-825b-d90c6c97e582)

 3) 코드 실행(순차도)<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/2c2b564a-b170-44d1-be74-2ab96aeeb3a1)

 4) 실행 결과
```
I can drive Sonata.
I can drive Grandeur.
I can drive BMW.
```
<br/>
<br/>
- 리스코프 치환 원칙(LSP)<br/>

 1) 실행 코드
```
public class Shape {

    public int width;
    public int height;

    // 너비 반환, Width Getter
    public int getWidth() {
        return width;
    }
    // 너비 할당, Width Setter
    public void setWidth(int width) {
        this.width = width;
    }

    // 높이 반환, Height Getter
    public int getHeight() {
        return height;
    }
    // 높이 할당, Height Setter
    public void setHeight(int height) {
        this.height = height;
    }

    // 사각형 넓이 반환
    public int getArea() {
        return width * height;
    }
}
//직사각형 클래스
public class Rectangle extends Shape {

    public Rectangle(int width, int height) {
        setWidth(width);
        setHeight(height);
    }
}
//정사각형 클래스
public class Square extends Shape{
    
    public Square(int length) {
        setWidth(length);
        setHeight(length);
    }
}
public class Main {
    public static void main(String[] args) {
    
        Shape rectangle = new Rectangle(10, 5);
        Shape square = new Square(5);
        
        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
    }
}
```
 
 2) 클래스도<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/a6146481-b1dd-4f94-bb69-a5ea3db02006)

 3) 코드 실행(순차도)<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/4e18f06a-87d6-40ec-a8d4-c0ab897d02e6)

 4) 실행 결과
```
50
25
```
<br/>
<br/>
- 인터페이스 분리 원칙(ISP)<br/>

 1) 실행 코드

```interface IPhone {
    void call(String number); // 통화 기능
    void message(String number, String text); // 문제 메세지 전송 기능
}

interface WirelessChargable {
    void wirelessCharge(); // 무선 충전 기능
}

interface ARable {
    void AR(); // 증강 현실(AR) 기능
}

interface Biometricsable {
    void biometrics(); // 생체 인식 기능
}
class S21 implements IPhone, WirelessChargable, ARable, Biometricsable {
    public void call(String number) {
        System.out.println("Calling " + number);
    }

    public void message(String number, String text) {
        System.out.println("Sending message to " + number + ": " + text);
    }

    public void wirelessCharge() {
        System.out.println("Wireless charging...");
    }

    public void AR() {
        System.out.println("Using augmented reality (AR) feature");
    }

    public void biometrics() {
        System.out.println("Performing biometric authentication");
    }
}
class S3 implements IPhone {
    public void call(String number) {
        System.out.println("Calling " + number);
    }

    public void message(String number, String text) {
        System.out.println("Sending message to " + number + ": " + text);
    }
}
public class Main {
    public static void main(String[] args) {
        S21 s21 = new S21();
        S3 s3 = new S3();

        s21.call("123-456-7890");
        s21.message("987-654-3210", "Hello, how are you?");
        s21.wirelessCharge();
        s21.AR();
        s21.biometrics();

        s3.call("555-1234");
        s3.message("987-654-3210", "Hi there!");
    }
}
```

 2) 클래스도<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/4b93cc38-d6aa-4e68-a6bd-ff23368c6c84)

 3) 코드 실행(순차도)<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/da429c91-a2bd-4d94-bfc0-de887b150a51)

 4) 실행 결과
```
Calling 123-456-7890
Sending message to 987-654-3210: Hello, how are you?
Wireless charging...
Using augmented reality (AR) feature
Performing biometric authentication
Calling 555-1234
Sending message to 987-654-3210: Hi there!
```
<br/>
<br/>
- 의존관계 역전 원칙(DIP)<br/>

 1) 실행 코드
```
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
```

 2) 클래스도<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/dde30a37-5308-43f3-9bf1-d1427f729b68)

 3) 코드 실행(순차도)<br/>
![image](https://github.com/Woojin-02/Study-SOLID/assets/64728336/62e21aee-f153-471e-8c58-9130f488b9b1)

 4) 실행 결과
```
Kid is playing with Robot
```


