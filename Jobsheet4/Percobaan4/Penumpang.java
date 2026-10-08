package Percobaan4;

public class Penumpang {
    private String ktp;
    private String nama;

    public Penumpang (String ktp, String nama){
        this.ktp = ktp;
        this.nama = nama;
    }

    public String getKtp(){
        return ktp;
    }

    public String getNama(){
        return nama;
    }

    public String info(){
        String info = "";
        info += "ktp: " + ktp + "\n";
        info += "nama: " + nama + "\n";
        return info;
    }
    
}
