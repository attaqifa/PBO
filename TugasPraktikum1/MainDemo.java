package TugasPraktikum1;

public class MainDemo {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        LampuMeja lampuMeja1 = new LampuMeja();
        Mobil mobil1 = new Mobil();
        Motor motor1 = new Motor();

        laptop1.setMerek("Acer");
        laptop1.setMemori(24);
        laptop1.cetakInfo();

        lampuMeja1.setWarnaCahaya("Merah");
        lampuMeja1.setdayaWatt(20);
        lampuMeja1.cetakInfo();

        mobil1.setMerk("Nissan");
        mobil1.setTahunProduksi(2021);
        mobil1.setKecepatan(120);
        mobil1.setJenisMobil("Family car");
        mobil1.setJumlahPintu(4);
        mobil1.cetakInfo();

        motor1.setMerk("Honda");
        motor1.setTahunProduksi(2025);
        motor1.setKecepatan(100);
        motor1.setJenisMotor("Motor Lakik");
        motor1.SetTipePenggerak("Rantai");
        motor1.cetakInfo();
    }
}
