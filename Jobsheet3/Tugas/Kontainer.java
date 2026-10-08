package Jobsheet3.Tugas;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private int kapasitasMaksimal;
    private int kapasitasSaatIni;

    Kontainer(String nomorResi, String namaPemilik, int kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public String getNomorResi(){
        return nomorResi;
    }
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public void tambahMuatan(int kapasitasSaatIni) {
        if (kapasitasSaatIni > kapasitasMaksimal) {
            System.out.println("Maaf, berat muatan melebihi kapasitas maksimal kontainer");
            kapasitasSaatIni = 0;
        } 
        this.kapasitasSaatIni = kapasitasSaatIni;
    }
    public int getKapasitasSaatIni(){
        return kapasitasSaatIni;
    }

    public void turunkanMuatan(int turunkanMuatan) {
        if (turunkanMuatan * 2 > kapasitasSaatIni) {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
            return;
        } else {
            this.kapasitasSaatIni -= turunkanMuatan;
        }
    }

}
