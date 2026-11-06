package tugas;

public class MainTugas {
    public static void main(String[] args) {
        Binatang[] binatang = {
            new Keledai("Keledai", 4, "Hehehehe", "Abu-Abu"),
            new Gorilla("Gulali", 4, "Haaum Hauum", "Hitam Manis"),
            new Singa("CingaCing", 4, "Roaar Roaaar", "Coklat")
        };

        for (Binatang b : binatang) {
            b.displayMakan();
            b.displayData();
        }
    }
}
