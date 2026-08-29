package Praktikum;

public class Mobil extends Kendaraan {
    private String jenisMobil;
    private int jumlahPintu;

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("jenisMobil: " + jenisMobil);
        System.out.println("jumlahPintu: " + jumlahPintu + "\n");
    }
}
