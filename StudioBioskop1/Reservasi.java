package StudioBioskop1;

public class Reservasi {
    private String kodeReservasi;
    private int jumlahTiket;
    private String operatorReservasi;

    public Reservasi() {
    }

    public Reservasi(String kodeReservasi, int jumlahTiket, String operatorReservasi) {
        this.kodeReservasi = kodeReservasi;
        this.jumlahTiket = jumlahTiket;
        this.operatorReservasi = operatorReservasi;
    }

    public void setKodeReservasi(String kodeReservasi) {
        this.kodeReservasi = kodeReservasi;
    }

    public String getKodeReservasi() {
        return kodeReservasi;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setOperatorReservasi(String operatorReservasi) {
        this.operatorReservasi = operatorReservasi;
    }

    public String getOperatorReservasi() {
        return operatorReservasi;
    }
}
