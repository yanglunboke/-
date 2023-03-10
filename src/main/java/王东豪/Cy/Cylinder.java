package 王东豪.Cy;

public class Cylinder implements A{

    private double r;
    private double h;

    public Cylinder() {
    }

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public double area() {
        return PI*r*r*2+2*PI*r*h;
    }

    @Override
    public void volume() {
        System.out.println("圆柱体体积:"+PI*r*r*h);
    }
}
