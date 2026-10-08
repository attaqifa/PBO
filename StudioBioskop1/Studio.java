package StudioBioskop1;

public class Studio {
    private String nama;
    private int tarif;

    public Studio() {
    }

    public Studio(String nama, int tarif) {
        this.nama = nama;
        this.tarif = tarif;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getTarif() {
        return tarif;
    }

}
