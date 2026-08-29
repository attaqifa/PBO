package Praktikum;

public class Laptop {
    private String merk;
    private int memori = 20;

    public void setMerek (String merk){
        this.merk = merk;
    }

    public void setMemori (int memoriValue){
        if (memoriValue <2 || memoriValue > 64) {
            System.out.println("Eror, memori harus terisi diantara 2 sampai dengan 64");
        } else {
            memori = memoriValue;
        }
    }

    public void cetakInfo(){
        System.out.println("Merek: " + merk);
        System.out.println("Memori: " + memori + "GB");
    }
}
