package Jobsheet3.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Viktor", "Jalan Mawar");
        System.out.println("Simpanan " + anggota1.getNama() + " : RP " + anggota1.getSimpanan());

        anggota1.setNama("Viktor Setiawan");
        anggota1.setAlamat("Jalan Soekarno Hatta no.10");
        anggota1.setor(100000);
        System.out.println("Simpanan " + anggota1.getNama() + " : RP " + anggota1.getSimpanan());

        anggota1.pinjam(50000);
        System.out.println("Simpanan " + anggota1.getNama() + " : RP " + anggota1.getSimpanan());

    }
}
