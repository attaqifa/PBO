package Praktikum;

public class LampuMeja {
    private String warnaCahaya;
    private int dayaWatt;

    public void setWarnaCahaya(String warnaCahaya) {
        this.warnaCahaya = warnaCahaya;
    }

    public void setdayaWatt(int dayaWatt) {
        this.dayaWatt = dayaWatt;
    }

    public void cetakInfo() {
        System.out.println("Warna cahaya: "+  warnaCahaya);
        System.out.println("Daya watt: " + dayaWatt + "W\n");
    }
}
