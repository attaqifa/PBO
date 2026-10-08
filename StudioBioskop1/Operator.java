package StudioBioskop1;

public class Operator {
    private String namaOperator;
    private int biaya;

    public Operator() {
    }

    public Operator(String namaOperator, int biaya) {
        this.namaOperator = namaOperator;
        this.biaya = biaya;
    }

    public void setNamaOperator(String namaOperator) {
        this.namaOperator = namaOperator;
    }

    public String getNamaOperator() {
        return namaOperator;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public int hitungTotalBiaya(Studio studio, int durasiPemutaran, Reservasi reservasi) {
        return studio.getTarif() * durasiPemutaran + biaya * reservasi.getJumlahTiket();
    }
}
