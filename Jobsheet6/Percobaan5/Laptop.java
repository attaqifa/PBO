package Jobsheet6.Percobaan5;

public class Laptop extends Komputer{
    protected int resolusiLayar;

    public Laptop( String merk, int memory, int cpu, int resolusiLayar){
        super(merk, memory, cpu);
        this.resolusiLayar = resolusiLayar;
    }

    @Override 
    public void showInfo (){
        super.showInfo();
        System.out.println("Resolusi Layar  : " + resolusiLayar + "p");
    }
    
}
