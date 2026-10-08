package Jobsheet6.percobaan1;

public class MainPerobaan1 {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();

        a.x = 10;
        a.y = 20;
        b.z = 30;

        a.getNilai();
        b.getNilaiZ();
        b.getJumlah();
    }
}
