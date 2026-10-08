package StudioBioskop1;

public class MainBioskop {
    public static void main(String[] args) {
        Studio studio1 = new Studio("Studio 1", 50000);
        Studio studio2 = new Studio("Studio 2", 60000);

        Reservasi reservasi1 = new Reservasi("101", 2, "Operator A");
        Reservasi reservasi2 = new Reservasi("102", 3, "Operator B");

        Operator operator1 = new Operator("Operator A", 10000);
        Operator operator2 = new Operator("Operator B", 15000);

        System.out.println("Informasi Studio:");
        System.out.println("Nama: " + studio1.getNama() + ", Tarif: " + studio1.getTarif());
        System.out.println("Nama: " + studio2.getNama() + ", Tarif: " + studio2.getTarif());

        System.out.println("Informasi Reservasi:");
        System.out.println("Kode Reservasi: " + reservasi1.getKodeReservasi() + ", Jumlah Tiket: " + reservasi1.getJumlahTiket()+ ", Operator: " + reservasi1.getOperatorReservasi());
        System.out.println("Kode Reservasi: " + reservasi2.getKodeReservasi()+ ", Jumlah Tiket: " + reservasi2.getJumlahTiket()+ ", Operator: " + reservasi2.getOperatorReservasi());

        System.out.println("Total Biaya:");
        System.out.println("Studio 1: " + operator1.hitungTotalBiaya(studio1, reservasi1.getJumlahTiket(), reservasi1));
        System.out.println("Studio 2: " + operator2.hitungTotalBiaya(studio2, reservasi2.getJumlahTiket(), reservasi2));
    }
}
