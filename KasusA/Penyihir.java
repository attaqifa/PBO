public class Penyihir extends Karakter {
    private int mana;

    public Penyihir(String nama, int hp, int dayaDasar, int mana) {
        super(nama, hp, dayaDasar);
        this.mana = mana;
    }

    @Override
    public int hitungDamage() {
        int baseDamage = super.hitungDamage();
        if (mana >= 10) {
            mana -= 10;
            return baseDamage * 2;
        } else {
            return baseDamage / 2;
        }
    }

    @Override
    public String info(){
        return super.info() +  " [Penyihir, mana=" + mana + "]";
    }
}