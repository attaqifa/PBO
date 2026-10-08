package Jobsheet6.percobaan3;

public class Tabung extends Bangun {
    protected int t;
    protected int r = 5;

    public void setSuperPhi(double phi) {
        this.phi = phi;
    }

    public void setSuperR(int r) {
        super.r = r;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void volume() {
        System.out.println("Volume Tabung: " + (this.phi * super.r * super.r * this.t));
    }

    public void cekR(){
        System.out.println("R:          = " + r);
        System.out.println("This R:    = " + this.r);
        System.out.println("Super R:    = " + super.r);
    }
}
