package TugasPraktikum1;

public class Motor extends Kendaraan {

    private String jenisMotor;
    private String tipePenggerak;

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public void SetTipePenggerak(String tipePenggerak) {
        this.tipePenggerak = tipePenggerak;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis motor: " + jenisMotor);
        System.out.println("Tipe Penggerak: " + tipePenggerak);
    }
}
