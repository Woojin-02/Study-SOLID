
interface IPhone {
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
