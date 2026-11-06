
public class Prajurit extends Karakter {

    public Prajurit(String nama, int hp, int dayaDasar) {
        super(nama, hp, dayaDasar);
    }

    @Override 
    public int hitungDamage(){
        int baseDamage = super.hitungDamage();
        if (getHp() < 0.5 * getHpMaks()){
            return baseDamage + 5;
        }
        return baseDamage;
    }

    @Override
    public String info() {
        return super.info() + "[Prajurit]";
    }
}