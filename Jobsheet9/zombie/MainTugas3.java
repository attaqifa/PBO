package zombie;

public class MainTugas3 {
    public static void main(String[] args) {
        Zombie z = new WalkingZombie(100, 1);
        Destroyable d = z;
        Zombie z3 = (Zombie) d;
        System.out.println(z3.getZombieInfo());

        // Zombie z2 = d;                  // error kompilasi: butuh cast eksplisit
        // Zombie z4 = new Zombie(100, 1); // error kompilasi: Zombie abstract
        // Destroyable d2 = new Plant();   // error kompilasi: Plant bukan Destroyable

        Zombie z5 = new JumpingZombie(100, 2);
        try {
            WalkingZombie w = (WalkingZombie) z5;
            System.out.println(w.getZombieInfo());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}
