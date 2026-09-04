package jobsheet2.Praktikum;

public class Circle {
    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    double area(){
        return 3.14 * radius * radius;
    }

    double circumference(){
        return 3.14 * radius;
    }
}
