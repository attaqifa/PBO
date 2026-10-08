package Jobsheet3.Tugas;
import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Kontainer kontainerAlfa = new Kontainer();
        Scanner input = new Scanner(System.in);

        
        System.out.println("Nomor resi: "+ kontainerAlfa.getNomorResi());
        System.out.println("Nama pemilik kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + "KG");

        System.out.print("\nMasukkan berat muatan baru (KG): ");
        int muatanBaru = input.nextInt();
        kontainerAlfa.tambahMuatan(muatanBaru);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getKapasitasSaatIni() + "KG");

        System.out.println("\nMenurunkan berat muatan baru (KG): ");
        muatanBaru = input.nextInt();
        kontainerAlfa.turunkanMuatan(muatanBaru);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getKapasitasSaatIni() + "KG");

    }
}

