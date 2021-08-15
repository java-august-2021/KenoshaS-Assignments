public class PhoneTest {
    public static void main(String[] args) {
    Galaxy s11 = new Galaxy("s11", 5, "Verizon", "Ding Ding");
    IPhone iPhone12 = new IPhone("12", 50, "ATT", "Ding");

    s11.displayInfo();
    System.out.println(s11.ring());
    System.out.println(s11.unlock());

    iPhone12.displayInfo();
    System.out.println(iPhone12.ring());
    System.out.println(iPhone12.unlock());
    }
}