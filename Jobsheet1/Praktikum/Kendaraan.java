package Praktikum;

public class Kendaraan {

    private String merk;
    private int tahunProduksi;
    private int kecepatan;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void cetakInfo() {
        System.out.println("Merk: " + merk);
        System.out.println("Tahun produksi: " + tahunProduksi);
        System.out.println("kecepatan: " + kecepatan + " KM/J");
    }

}
