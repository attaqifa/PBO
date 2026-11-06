package zombie;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] targets = {wz, jz, b};
        for (int i = 0; i < 4; i++) {
            for (Destroyable target : targets) {
                p.doDestroy(target);
            }
        }

        for (Destroyable target : targets) {
            if (target instanceof Zombie z) {
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (target instanceof Barrier barrier) {
                System.out.println(barrier.getBarrierInfo());
            }
        }
    }
}
