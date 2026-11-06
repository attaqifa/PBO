public class Arena {

    public String duel(Prajurit prajurit, Penyihir penyihir) {
        int ronde = 1;
        while (prajurit.isHidup() && penyihir.isHidup()) {
            System.out.println("Ronde " + ronde);


            // Prajurit menyerang
            int dmgPrajurit = prajurit.hitungDamage();
            penyihir.terimaDamage(dmgPrajurit);
            System.out.println(prajurit.getNama() + " menyerang " + penyihir.getNama() + ": " + dmgPrajurit + " -> sisa HP " + penyihir.getHp());

            if (!penyihir.isHidup()) {
                break;
            }

            // Penyihir menyerang
            int dmgPenyihir = penyihir.hitungDamage();
            prajurit.terimaDamage(dmgPenyihir);
            System.out.println(penyihir.getNama() + " menyerang " + prajurit.getNama() + ": " + dmgPenyihir + " -> sisa HP " + prajurit.getHp());

            ronde++;
        }

        if (prajurit.isHidup()) {
            return prajurit.info();
        } else {
            return penyihir.info();
        }
    }
}