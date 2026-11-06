
public class Karakter {
    private String nama;
    private int hp;
    private int hpMaks;
    private int dayaDasar;
    private Senjata senjata;

    public Karakter(String nama, int hp, int dayaDasar) {
        this.nama = nama;
        this.hp = hp;
        this.dayaDasar = dayaDasar;
        this.senjata = null;
    }

    public void pasangSenjata(Senjata Senjata) {
        this.senjata = senjata;
    }

    public int hitungDamage() {
        int bonus = (senjata != null) ? senjata.getBonusDamage() : 0;
        return dayaDasar + bonus;
    }

    public void terimaDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isHidup() {
        return this.hp > 0;
    }

    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMaks() {
        return hpMaks;
    }

    public String info() {
        return nama + " (" + hp + "/" + hpMaks + ")";
    }
}