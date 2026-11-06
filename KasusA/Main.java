public class Main {
    public static void main(String[] args) {
        Senjata pedang = new Senjata("Pedang Baja", 8);
        Senjata tongkat = new Senjata("Tongkat Api", 6);

        Prajurit arga = new Prajurit("Arga", 100, 12);
        Penyihir luna = new Penyihir("Luna", 80, 7, 30);
        arga.pasangSenjata(pedang);
        luna.pasangSenjata(tongkat);

        System.out.println(arga.info());
        System.out.println(luna.info());
        System.out.println("Damage Arga: " + arga.hitungDamage());
        Arena arena = new Arena();
        String pemenang = arena.duel(arga, luna);
        System.out.println("Pemenang: " + pemenang);
    }
    /*Jawaban Tugas 3
    Kita Memakai ulang mehtod hitungDamage() milik class karakter dengan memakai super. hitungDamage() nantinya menghitung daya dasar ditambah dengan bonus senjata.
    mehtod hitungDamage() di override untuk menambahkan logika kelipatan serangan pada pemanah. */
}
