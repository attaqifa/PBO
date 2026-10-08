package Jobsheet3.Tugas;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(40);

        System.out.println("Nama: " + encap.getName());
        System.out.println("Umur: " + encap.getAge());
    }
}
